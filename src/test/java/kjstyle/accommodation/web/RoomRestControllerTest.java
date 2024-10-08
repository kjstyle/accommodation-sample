package kjstyle.accommodation.web;

import kjstyle.accommodation.common.BaseMockMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class RoomRestControllerTest extends BaseMockMvcTest {

    @Test
    void 방목록_조회_테스트() throws Exception {
        final ResultActions resultActions = this.mockMvc.perform(
                get("/api/room/1")
                        .contentType(MediaType.APPLICATION_JSON)
        );
        resultActions.andExpect(status().isOk());
    }
}