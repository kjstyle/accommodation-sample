package kjstyle.accommodation.domain.model;

import kjstyle.accommodation.domain.enums.AccommodationStatus;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor // 스프링캐시에 넣으려면 Deserialization할 때 NoArgsConstructor가 있거나 setter가 있어야하는데..여튼 어쩔 수 없이 추가
@Builder
public class Accommodation {
    private long id;
    private String name;
    private String description;
    private GeoLocation geoLocation;
    private AccommodationType type;
    private AccommodationStatus status;
    private ParkingInfo parkingInfo;
    private String locationGuideText;

    @Setter // 숙소정보를 가지고와서 메인이미지 path만 추가로 세팅해야해서
    private String mainImagePath; // 역정규화? 느낌으로 넣은거고.. 썸네일 등 자주 조회하는 녀석이 추가될 수 있음

    public static Accommodation of(AccommodationEntity entity, String mainImagePath) {
        return Accommodation.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .geoLocation(new GeoLocation(entity.getLatitude(), entity.getLongitude()))
                .type(entity.getType())
                .parkingInfo(new ParkingInfo(entity.isFreeParking(), entity.getParkingType()))
                .locationGuideText(entity.getLocationGuideText())
                .mainImagePath(mainImagePath)
                .build();
    }

    public AccommodationEntity toSaveEntity() {
        return AccommodationEntity.builder()
                .name(this.name)
                .description(this.description)
                .latitude(this.geoLocation.getLatitude())
                .longitude(this.geoLocation.getLongitude())
                .type(this.type)
                .isFreeParking(this.parkingInfo.getIsFree())
                .parkingType(this.parkingInfo.getParkingType())
                .locationGuideText(this.locationGuideText)
                .build();
    }
}