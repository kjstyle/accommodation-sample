package kjstyle.accommodation.domain.service;

import kjstyle.accommodation.domain.model.Room;
import kjstyle.accommodation.domain.repository.RoomRepository;
import kjstyle.accommodation.domain.repository.entities.RoomEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<Room> findRoomsByAccommodationId(long accommodationId) {
        List<RoomEntity> roomEntityList = roomRepository.findAllByAccommodationId(accommodationId);
        List<Room> roomList = roomEntityList.stream().map(Room::from).toList();
        return roomList;
    }
}