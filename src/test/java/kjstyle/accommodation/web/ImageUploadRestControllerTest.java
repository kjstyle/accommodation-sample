package kjstyle.accommodation.web;

import kjstyle.accommodation.common.BaseMockMvcTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ImageUploadRestControllerTest extends BaseMockMvcTest {

    private static final String TEMP_PATH = "tmpfile/accommodation/MAIN";

    @Test
    void 이미지업로드_컨트롤러_테스트() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("image", "test-image.jpg", MediaType.IMAGE_JPEG_VALUE, "Test image content".getBytes());

        mockMvc.perform(
                multipart("/api/upload/image/accommodation")
                        .file(mockMultipartFile)
                        .param("imageType", "MAIN")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imageType").value("MAIN"))
                .andExpect(jsonPath("$.path").exists());
    }

    @Test
    void 비어있는_이미지_업로드_컨트롤러_테스트_400에러_나야하는데() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("image", "test-image.jpg", MediaType.IMAGE_JPEG_VALUE, new byte[0]);
        mockMvc.perform(
                        multipart("/api/upload/image/accommodation")
                                .file(mockMultipartFile)
                                .param("imageType", "MAIN")
                                .contentType(MediaType.MULTIPART_FORM_DATA)
                )
                .andExpect(status().isBadRequest());
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