package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.common.BaseJpaTest;
import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.exceptions.NotFoundImageException;
import kjstyle.accommodation.domain.repository.entities.AccommodationImageEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class AccommodationImageRepositoryTest extends BaseJpaTest {
    @Autowired
    private AccommodationImageRepository accommodationImageRepository;

    @Test
    void 메인이미지조회() throws Exception {
        AccommodationImageEntity accommodationImageEntity = accommodationImageRepository.findByAccommodationIdAndImageType(1L, ImageType.MAIN).orElseThrow(NotFoundImageException::new);
        Assertions.assertNotNull(accommodationImageEntity);
        assertThat(accommodationImageEntity).isNotNull();
    }

    @Test
    void 이미지저장테스트() throws Exception {
        AccommodationImageEntity accommodationImageEntity = AccommodationImageEntity.builder()
                .accommodationId(1L)
                .path("/img/test/123.jpg")
                .imageType(ImageType.MAIN)
                .build();
        AccommodationImageEntity saved = accommodationImageRepository.save(accommodationImageEntity);
        assertThat(saved.getPath()).isEqualTo(accommodationImageEntity.getPath());
    }
}