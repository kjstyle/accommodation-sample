package kjstyle.accommodation.web;

import kjstyle.accommodation.domain.repository.common.BaseMockMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ImageUploadRestControllerTest extends BaseMockMvcTest {

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
}