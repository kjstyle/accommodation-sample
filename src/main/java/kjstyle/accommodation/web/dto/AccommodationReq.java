package kjstyle.accommodation.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kjstyle.accommodation.domain.GeoLocation;
import kjstyle.accommodation.domain.ParkingInfo;
import kjstyle.accommodation.domain.enums.AccommodationStatus;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.web.validators.ValidAccommodationImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AccommodationReq {

    @Getter
    public static class Create {
        @NotBlank(message = "숙소명은 필수입니다.")
        private String name;

        private String description;

        @NotNull
        private GeoLocation geoLocation;

        @NotNull
        private AccommodationType type;

        @NotNull
        private AccommodationStatus status;

        @NotNull
        private ParkingInfo parkingInfo;

        private String locationGuideText;

        @NotNull
        @ValidAccommodationImage
        private List<ImageOnCreate> imageList;

        @Builder
        public Create(String name, String description, GeoLocation geoLocation, AccommodationType type, ParkingInfo parkingInfo, String locationGuideText, List<ImageOnCreate> imageList) {
            this.name = name;
            this.description = description;
            this.geoLocation = geoLocation;
            this.type = type;
            this.status = AccommodationStatus.AVALIABLE;
            this.parkingInfo = parkingInfo;
            this.locationGuideText = locationGuideText;
            this.imageList = imageList;
        }
    }

    @Getter
    public static class ImageOnCreate {
        private ImageType imageType;
        private String path;

        @Builder
        public ImageOnCreate(ImageType imageType, String path) {
            this.imageType = imageType;
            this.path = path;
        }
    }
}
