package kjstyle.accommodation.domain.service;

import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.exceptions.NotFoundAccommodationException;
import kjstyle.accommodation.domain.exceptions.NotFoundImageException;
import kjstyle.accommodation.domain.model.Accommodation;
import kjstyle.accommodation.domain.model.AccommodationImage;
import kjstyle.accommodation.domain.repository.AccommodationRepository;
import kjstyle.accommodation.domain.repository.ImageRepository;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "accommodation", key = "#id", cacheManager = "accommodationCacheManager", condition = "#id > 0")
    public Accommodation findById(long id) {
        AccommodationEntity accommodationEntity = accommodationRepository.findById(id).orElseThrow(NotFoundAccommodationException::new);
        ImageEntity mainImageEntity = imageRepository.findByAccommodationIdAndImageType(id, ImageType.MAIN).orElseThrow(NotFoundImageException::new);
        return Accommodation.of(accommodationEntity, mainImageEntity.getPath());
    }

    @Transactional
    public Accommodation create(Accommodation accommodation, List<AccommodationImage> imageList) {
        AccommodationEntity savedAccommodationEntity = accommodationRepository.save(accommodation.toSaveEntity());
        long newAccommodationId = savedAccommodationEntity.getId();

        List<ImageEntity> imageEntities = imageList.stream()
                .map(accommodationImage -> accommodationImage.toSaveEntity(newAccommodationId))
                .toList();

        // TODO : 화면에서 이미지를 미리 등록하고, 이미지 key 리스트만 받고, 등록된 숙소 key만 update해주면 되지 싶은데.. 아래코드가 맘에 안든다...
        Iterable<ImageEntity> savedImageEntities = imageRepository.saveAll(imageEntities);
        String mainImagePath = StreamSupport.stream(savedImageEntities.spliterator(), false)
                .filter(imageEntity -> imageEntity.getImageType().equals(ImageType.MAIN))
                .map(ImageEntity::getPath)
                .findFirst().orElse("/img/default_main_img.jpg");

        return Accommodation.of(savedAccommodationEntity, mainImagePath);
    }
}