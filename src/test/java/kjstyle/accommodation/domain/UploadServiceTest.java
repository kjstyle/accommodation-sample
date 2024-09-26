package kjstyle.accommodation.domain;

import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.repository.ImageRepository;
import kjstyle.accommodation.domain.repository.common.BaseTest;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import kjstyle.accommodation.domain.service.UploadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class UploadServiceTest extends BaseTest {

    @Autowired
    private UploadService uploadService;

    @MockBean
    private ImageRepository imageRepository;

    @Test
    void 이미지_업로드_테스트() throws IOException {

        MockMultipartFile mockMultipartFile = new MockMultipartFile("image", "test-image.jpg", MediaType.IMAGE_JPEG_VALUE, "Test image content".getBytes());
        ImageEntity mockImageEntity = ImageEntity.builder()
                .id(123L)
                .imageType(ImageType.MAIN)
                .path("accommodation/main/12345.jpg")
                .build();

        when(imageRepository.save(any(ImageEntity.class))).thenReturn(mockImageEntity);

        ImageEntity savedImageEntity = uploadService.uploadAccommodationImage(ImageType.MAIN, mockMultipartFile);

        assertThat(savedImageEntity).isNotNull();
        assertThat(savedImageEntity.getImageType()).isEqualTo(ImageType.MAIN);
        assertThat(savedImageEntity.getPath()).isEqualTo("accommodation/main/12345.jpg");
        assertThat(savedImageEntity.getId()).isEqualTo(123L);

        verify(imageRepository, times(1)).save(any(ImageEntity.class));
    }
}