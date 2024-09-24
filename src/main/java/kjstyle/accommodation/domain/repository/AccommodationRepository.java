package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccommodationRepository extends JpaRepository<AccommodationEntity, Long> {
    Optional<AccommodationEntity> findById(long id);
}
