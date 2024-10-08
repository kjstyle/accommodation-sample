package kjstyle.accommodation.domain.model;

import kjstyle.accommodation.domain.repository.entities.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor // 스프링캐시에 넣으려면 Deserialization할 때 NoArgsConstructor가 있거나 setter가 있어야하는데..여튼 어쩔 수 없이 추가
@Builder
@Getter
public class Room {
    private Long id;
    private String roomName;
    private String description;
    private Integer minOccupancy;
    private Integer maxOccupancy;
    private String bedTypeDescription;
    private int bedCount;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private String promotionText;

    public static Room from(RoomEntity entity) {
        return Room.builder()
                .id(entity.getId())
                .roomName(entity.getRoomName())
                .description(entity.getDescription())
                .minOccupancy(entity.getMinOccupancy())
                .maxOccupancy(entity.getMaxOccupancy())
                .bedTypeDescription(entity.getBedTypeDescription())
                .bedCount(entity.getBedCount())
                .checkInTime(entity.getCheckInTime())
                .checkOutTime(entity.getCheckOutTime())
                .promotionText(entity.getPromotionText())
                .build();
    }
}