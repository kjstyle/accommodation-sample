package kjstyle.accommodation.web;

import kjstyle.accommodation.domain.model.Room;
import kjstyle.accommodation.domain.service.RoomService;
import kjstyle.accommodation.web.common.BaseApiController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class RoomRestController extends BaseApiController {

    private final RoomService roomService;

    @GetMapping("/room/{id}")
    public List<Room> getRooms(@PathVariable Long id) {
        return roomService.findRoomsByAccommodationId(id);
    }
}