package kjstyle.accommodation.domain;

import kjstyle.accommodation.domain.enums.AccommodationStatus;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
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
    private String mainImagePath;

    public static Accommodation of(AccommodationEntity entity, ImageEntity mainImageEntity) {
        return Accommodation.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .geoLocation(new GeoLocation(entity.getLatitude(), entity.getLongitude()))
                .type(entity.getType())
                .parkingInfo(new ParkingInfo(entity.isFreeParking(), entity.getParkingType()))
                .locationGuideText(entity.getLocationGuideText())
                .mainImagePath(mainImageEntity.getPath())
                .build();
    }
}