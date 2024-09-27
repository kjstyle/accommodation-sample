package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccommodationRepository extends CrudRepository<AccommodationEntity, Long> {

    Optional<AccommodationEntity> findById(long id);

//    @EntityGraph(attributePaths = {"accommodationAmenityList"})
//    @Query("SELECT a FROM AccommodationEntity a JOIN a.accommodationAmenityList aam INNER JOIN aam.amenity amen WHERE a.id = :id")
//    Optional<AccommodationEntity> findAccommodationWithAmenities(@Param("id") Long id);
}