package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.repository.entities.RoomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
    List<RoomEntity> findAllByAccommodationId(Long accommodationId);
}
