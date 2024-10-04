package kjstyle.accommodation.domain;

import kjstyle.accommodation.common.BaseTest;
import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.repository.ImageRepository;
import kjstyle.accommodation.domain.repository.entities.ImageEntity;
import kjstyle.accommodation.domain.service.UploadService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UploadServiceTest extends BaseTest {

    @Autowired
    private UploadService uploadService;

    @MockBean
    private ImageRepository imageRepository;

    private static final String TEMP_PATH = "tmpfile/accommodation/MAIN";

    @Test
    void 이미지_업로드_테스트() throws IOException {

        MockMultipartFile mockMultipartFile = new MockMultipartFile("image", "test-image.jpg", MediaType.IMAGE_JPEG_VALUE, "Test image content".getBytes());
        ImageEntity mockImageEntity = ImageEntity.builder()
                .id(123L)
                .imageType(ImageType.MAIN)
                .path(TEMP_PATH+"/12345.jpg")
                .build();

        when(imageRepository.save(any(ImageEntity.class))).thenReturn(mockImageEntity);

        ImageEntity savedImageEntity = uploadService.uploadAccommodationImage(ImageType.MAIN, mockMultipartFile);

        assertThat(savedImageEntity).isNotNull();
        assertThat(savedImageEntity.getImageType()).isEqualTo(ImageType.MAIN);
        assertThat(savedImageEntity.getPath()).isEqualTo(TEMP_PATH + "/12345.jpg");
        assertThat(savedImageEntity.getId()).isEqualTo(123L);

        verify(imageRepository, times(1)).save(any(ImageEntity.class));
    }


    @AfterAll
    static void cleanUpAll() throws Exception {
        // 테스트로 저장했던 임시파일들 삭제 (안그럼 계속 누적될거라...)
        Path tempDir = Paths.get(TEMP_PATH);
        // 디렉토리가 존재하면 파일 삭제
        if (Files.exists(tempDir)) {
            Files.walk(tempDir)
                    .map(Path::toFile)
                    .forEach(file -> {
                        if (!file.delete()) {
                            System.err.println("Failed to delete file: " + file);
                        }
                    });
        }
    }
}