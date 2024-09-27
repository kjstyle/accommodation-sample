package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ParkingType;
import kjstyle.accommodation.domain.exceptions.NotFoundAccommodationException;
import kjstyle.accommodation.domain.repository.common.BaseJpaTest;
import kjstyle.accommodation.domain.repository.entities.AccommodationAmenityEntity;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import kjstyle.accommodation.domain.repository.entities.AmenityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    void 숙소조회테스트_Lazy테스트() {
        AccommodationEntity entity = accommodationRepository.findById(1L).orElseThrow(NotFoundAccommodationException::new);
        List<AccommodationAmenityEntity> accommodationAmenityEntityList = entity.getAccommodationAmenityList();
        assertThat(accommodationAmenityEntityList.size()).isEqualTo(3);
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

    @Test
    void 숙소랑시설_같이_가지고오기() {

        Optional<AccommodationEntity> accommodationWithAmenities = accommodationRepository.findAccommodationWithAmenities(1L);
        AccommodationEntity accommodationEntity = accommodationWithAmenities.get();
        String name = accommodationEntity.getAccommodationAmenityList().getFirst().getAmenity().getName();
        List<AccommodationAmenityEntity> accommodationAmenityList = accommodationEntity.getAccommodationAmenityList();
        assertThat(accommodationAmenityList.size()).isEqualTo(3);
    }
}