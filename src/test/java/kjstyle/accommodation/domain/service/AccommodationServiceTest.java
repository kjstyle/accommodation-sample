package kjstyle.accommodation.domain.service;

import kjstyle.accommodation.common.BaseRedisTest;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.enums.ParkingType;
import kjstyle.accommodation.domain.model.Accommodation;
import kjstyle.accommodation.domain.model.AccommodationImage;
import kjstyle.accommodation.domain.model.GeoLocation;
import kjstyle.accommodation.domain.model.ParkingInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class AccommodationServiceTest extends BaseRedisTest {

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void 숙소저장테스트() {
        Accommodation accommodation = Accommodation.builder()
                .name("비산호텔")
                .type(AccommodationType.HOTEL)
                .locationGuideText("비산사거리에 위치한 호텔")
                .geoLocation(new GeoLocation(37.39716397544742, 126.93087253698494))
                .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                .description("안양 최고의 호텔")
                .regionId(7L)
                .build();

        Accommodation saved = accommodationService.create(accommodation, Arrays.asList(
                AccommodationImage.builder().imageType(ImageType.MAIN).path("/img/1.jpg").build()
                ,AccommodationImage.builder().imageType(ImageType.DETAIL).path("/img/2.jpg").build()
                ,AccommodationImage.builder().imageType(ImageType.THUMBNAIL).path("/img/3.jpg").build()
        ));

        assertThat(saved).isNotNull();
    }

    @Test
    void 숙소조회_캐시_잘_걸리나_테스트() {
        // 키를 evict하고
        cacheManager.getCache("accommodation").evict(1L);

        // 1인 키는 레디스에서 조회하면 당근 없을거고
        assertThat(cacheManager.getCache("accommodation").get(1L)).isNull();

        // 호출될때 캐시에 구워질테고
        accommodationService.findById(1L);

        // 호출된 다음 캐시를 조회해보면 해당키로 조회가 되면 성공
        assertThat(cacheManager.getCache("accommodation").get(1L)).isNotNull();
    }
}