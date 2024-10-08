package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.common.BaseJpaTest;
import kjstyle.accommodation.domain.repository.entities.RoomEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class RoomRepositoryTest extends BaseJpaTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void 숙소번호로_방목록_조회하기() {
        List<RoomEntity> list = roomRepository.findAllByAccommodationId(1L);
        Assertions.assertThat(list.size()).isGreaterThan(0);
    }
}