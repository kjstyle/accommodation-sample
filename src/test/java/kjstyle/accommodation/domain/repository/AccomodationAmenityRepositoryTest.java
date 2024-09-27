package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.repository.common.BaseJpaTest;
import kjstyle.accommodation.domain.repository.entities.AmenityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AccomodationAmenityRepositoryTest extends BaseJpaTest {

    @Autowired
    private AccomodationAmenityRepository accomodationAmenityRepository;

    @Test
    void 특정_숙소의_어매니티들_가져오기_테스트() {
        List<AmenityEntity> amenityEntityList = accomodationAmenityRepository.findAmenitiesByAccommodationId(1L);
        assertThat(amenityEntityList.size()).isEqualTo(3);
        assertThat(amenityEntityList.get(0).getName()).isEqualTo("에어컨");
    }
}