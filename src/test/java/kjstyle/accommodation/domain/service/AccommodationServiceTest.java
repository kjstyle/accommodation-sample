package kjstyle.accommodation.domain.service;

import kjstyle.accommodation.domain.Accommodation;
import kjstyle.accommodation.domain.AccommodationImage;
import kjstyle.accommodation.domain.GeoLocation;
import kjstyle.accommodation.domain.ParkingInfo;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.enums.ParkingType;
import kjstyle.accommodation.domain.repository.common.BaseTest;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class AccommodationServiceTest extends BaseTest {

    @Autowired
    private AccommodationService accommodationService;

    @Test
    void 숙소저장테스트() {
        Accommodation accommodation = Accommodation.builder()
                .name("비산호텔")
                .type(AccommodationType.HOTEL)
                .locationGuideText("비산사거리에 위치한 호텔")
                .geoLocation(new GeoLocation(37.39716397544742, 126.93087253698494))
                .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                .description("안양 최고의 호텔")
                .build();
        Accommodation saved = accommodationService.save(accommodation, Arrays.asList(
                AccommodationImage.builder().imageType(ImageType.MAIN).path("/img/1.jpg").build()
                ,AccommodationImage.builder().imageType(ImageType.DETAIL).path("/img/2.jpg").build()
                ,AccommodationImage.builder().imageType(ImageType.THUMBNAIL).path("/img/3.jpg").build()
        ));
        assertThat(saved).isNotNull();
    }
}