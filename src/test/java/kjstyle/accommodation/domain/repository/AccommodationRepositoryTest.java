package kjstyle.accommodation.domain.repository;

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
}