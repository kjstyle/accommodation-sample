package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.common.BaseJpaTest;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ParkingType;
import kjstyle.accommodation.domain.exceptions.NotFoundAccommodationException;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class AccommodationRepositoryTest extends BaseJpaTest {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Test
    void 숙소조회테스트fromDB() {
        AccommodationEntity entity = accommodationRepository.findById(1L).orElseThrow(NotFoundAccommodationException::new);
        assertThat(entity.getName()).isEqualTo("서울 호텔");
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
        assertThat(saved.getName()).isEqualTo(accommodationEntity.getName());
    }
}