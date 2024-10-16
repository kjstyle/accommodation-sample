package kjstyle.accommodation.domain.repository;


import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.repository.entities.AccommodationImageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccommodationImageRepository extends CrudRepository<AccommodationImageEntity, Long> {
    Optional<AccommodationImageEntity> findByAccommodationIdAndImageType(Long accommodationId, ImageType imageType);

    List<AccommodationImageEntity> findAllByAccommodationIdInAndImageType(List<Long> accommodationIdList, ImageType imageType);
}