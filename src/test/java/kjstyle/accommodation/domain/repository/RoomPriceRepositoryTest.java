package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.common.BaseJpaTest;
import kjstyle.accommodation.domain.repository.entities.RoomPriceEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class RoomPriceRepositoryTest extends BaseJpaTest {

    @Autowired
    private RoomPriceRepository roomPriceRepository;

    @Test
    void 방_가격조회() {
        List<RoomPriceEntity> roomPriceEntityList = roomPriceRepository.findAllByRoomId(1L);
        Assertions.assertThat(roomPriceEntityList.size()).isGreaterThan(0);
    }
}