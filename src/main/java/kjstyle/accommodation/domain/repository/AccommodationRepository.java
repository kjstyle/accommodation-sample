package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccommodationRepository extends CrudRepository<AccommodationEntity, Long> {

    Optional<AccommodationEntity> findById(long id);

}