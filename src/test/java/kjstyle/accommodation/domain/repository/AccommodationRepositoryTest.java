package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.BaseJpaTest;
import kjstyle.accommodation.domain.exceptions.NotFoundSuchAccommodationException;
import kjstyle.accommodation.domain.repository.entities.AccommodationEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AccommodationRepositoryTest extends BaseJpaTest {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Test
    void 숙소조회테스트fromDB() {
        AccommodationEntity entity = accommodationRepository.findById(1L).orElseThrow(NotFoundSuchAccommodationException::new);
        Assertions.assertEquals("서울 호텔", entity.getName());
    }

}