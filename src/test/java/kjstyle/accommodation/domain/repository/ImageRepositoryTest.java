package kjstyle.accommodation.domain.repository;

import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.exceptions.NotFoundImageException;
import kjstyle.accommodation.domain.repository.common.BaseJpaTest;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


class ImageRepositoryTest extends BaseJpaTest {
    @Autowired
    private ImageRepository imageRepository;

    @Test
    void 메인이미지조회() throws Exception {
        ImageEntity imageEntity = imageRepository.findByAccommodationIdAndImageType(1L, ImageType.MAIN).orElseThrow(NotFoundImageException::new);
        Assertions.assertNotNull(imageEntity);
        assertThat(imageEntity).isNotNull();
    }

    @Test
    void 이미지저장테스트() throws Exception {
        ImageEntity imageEntity = ImageEntity.builder()
                .accommodationId(1L)
                .path("/img/test/123.jpg")
                .imageType(ImageType.MAIN)
                .build();
        ImageEntity saved = imageRepository.save(imageEntity);
        assertThat(saved.getPath()).isEqualTo(imageEntity.getPath());
    }
}