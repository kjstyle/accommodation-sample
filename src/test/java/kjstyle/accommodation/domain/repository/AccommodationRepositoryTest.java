package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ParkingType;
import kjstyle.accommodation.domain.repository.common.BaseJpaTest;
import kjstyle.accommodation.domain.exceptions.NotFoundAccommodationException;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccommodationRepositoryTest extends BaseJpaTest {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Test
    void 숙소조회테스트fromDB() {
        AccommodationEntity entity = accommodationRepository.findById(1L).orElseThrow(NotFoundAccommodationException::new);
        Assertions.assertEquals("서울 호텔", entity.getName());
    }

    @Test
    void 숙소저장테스트toDB() {
        AccommodationEntity accommodationEntity = AccommodationEntity.builder()
                .name("비산호텔")
                .type(AccommodationType.HOTEL)
                .locationGuideText("비산사거리에 위치한 호텔")
                .longitude(37.39716397544742)
                .latitude(126.93087253698494)
                .parkingType(ParkingType.MACHINE)
                .description("안양 최고의 호텔")
                .isFreeParking(true)
                .build();

        AccommodationEntity saved = accommodationRepository.save(accommodationEntity);
        Assertions.assertEquals(accommodationEntity.getName(), saved.getName());
    }
}