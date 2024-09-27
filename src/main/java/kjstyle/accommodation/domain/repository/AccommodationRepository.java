package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccommodationRepository extends CrudRepository<AccommodationEntity, Long> {

    Optional<AccommodationEntity> findById(long id);

    @EntityGraph(attributePaths = {"accommodationAmenityList"})
    //@Query("SELECT a FROM AccommodationEntity a WHERE a.id = :id")
    @Query("SELECT a FROM AccommodationEntity a JOIN a.accommodationAmenityList aam INNER JOIN aam.amenity amen WHERE a.id = :id")
    Optional<AccommodationEntity> findAccommodationWithAmenities(@Param("id") Long id);
}