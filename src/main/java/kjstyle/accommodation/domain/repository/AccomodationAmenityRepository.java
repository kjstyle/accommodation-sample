package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.repository.entities.AccommodationAmenityEntity;
import kjstyle.accommodation.domain.repository.entities.AmenityEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationAmenityRepository extends CrudRepository<AccommodationAmenityEntity, Long> {

    @Query("SELECT a.amenity FROM AccommodationAmenityEntity a WHERE a.accommodation.id = :accommodationId")
    List<AmenityEntity> findAmenitiesByAccommodationId(@Param("accommodationId") Long accommodationId);
}