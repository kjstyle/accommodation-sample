package kjstyle.accommodation.domain.repository;


import kjstyle.accommodation.domain.repository.entities.RoomPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomPriceRepository extends JpaRepository<RoomPriceEntity, Long> {
    List<RoomPriceEntity> findAllByRoomId(Long roomId);
}