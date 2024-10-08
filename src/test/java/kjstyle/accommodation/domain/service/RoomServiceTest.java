package kjstyle.accommodation.domain.service;

import kjstyle.accommodation.common.BaseTest;
import kjstyle.accommodation.domain.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
class RoomServiceTest extends BaseTest {

    @Autowired
    private RoomService roomService;

    @Test
    void 숙소번호로_방목록_조회() {
        List<Room> roomList = roomService.findRoomsByAccommodationId(1L);
        Assertions.assertThat(roomList.size()).isGreaterThan(0);
    }
}