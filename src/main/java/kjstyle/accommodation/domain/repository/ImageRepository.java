package kjstyle.accommodation.domain.repository;


import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends CrudRepository<ImageEntity, Long> {
    Optional<ImageEntity> findByAccommodationIdAndImageType(Long accommodationId, ImageType imageType);

    List<ImageEntity> findAllByAccommodationIdInAndImageType(List<Long> accommodationIdList, ImageType imageType);
}