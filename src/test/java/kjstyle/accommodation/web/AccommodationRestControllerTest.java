package kjstyle.accommodation.web;

import kjstyle.accommodation.domain.repository.common.BaseMockMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccommodationRestControllerTest extends BaseMockMvcTest {
    @Test
    void 숙소조회API호출테스트() throws Exception {
        final ResultActions resultActions = this.mockMvc.perform(
                get("/api/accommodation/1")
                        .contentType(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(status().isOk());
    }

    @Test
    void 없는숙소조회테스트() throws Exception {
        final ResultActions resultActions = this.mockMvc.perform(
                get("/api/accommodation/0")
                        .contentType(MediaType.APPLICATION_JSON)
        );
        resultActions
                .andExpect(status().isBadRequest())
        ;
    }
}