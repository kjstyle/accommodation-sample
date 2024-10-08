package kjstyle.accommodation.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import kjstyle.accommodation.common.BaseMockMvcTest;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ImageType;
import kjstyle.accommodation.domain.enums.ParkingType;
import kjstyle.accommodation.domain.model.GeoLocation;
import kjstyle.accommodation.domain.model.ParkingInfo;
import kjstyle.accommodation.web.dto.AccommodationReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class AccommodationRestControllerTest extends BaseMockMvcTest {

    @Autowired
    private ObjectMapper objectMapper;


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

    @Test
    void 숙소등록테스트() throws Exception {
        String requestBody = objectMapper.writeValueAsString(
            AccommodationReq.Create.builder()
                    .name("비산호텔")
                    .type(AccommodationType.HOTEL)
                    .locationGuideText("비산사거리에 위치한 호텔")
                    .geoLocation(new GeoLocation(37.39716397544742, 126.93087253698494))
                    .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                    .description("안양 최고의 호텔")
                    .imageList(Arrays.asList(
                            AccommodationReq.ImageOnCreate.builder().imageType(ImageType.MAIN).path("/img/1.jpg").build()
                            ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.THUMBNAIL).path("/img/2.jpg").build()
                            ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.DETAIL).path("/img/3.jpg").build()
                    ))
                    .build()
        );
        final ResultActions resultActions = this.mockMvc.perform(
                post("/api/accommodation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        );

        resultActions.andExpect(status().isOk());
    }

    @Test
    void 숙소명을_빼먹고_post를_날려보자() throws Exception {
        String requestBody = objectMapper.writeValueAsString(
                AccommodationReq.Create.builder()
                        .name("")
                        .type(AccommodationType.HOTEL)
                        .locationGuideText("비산사거리에 위치한 호텔")
                        .geoLocation(new GeoLocation(37.39716397544742, 126.93087253698494))
                        .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                        .description("안양 최고의 호텔")
                        .imageList(Arrays.asList(
                                AccommodationReq.ImageOnCreate.builder().imageType(ImageType.MAIN).path("/img/1.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.THUMBNAIL).path("/img/2.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.DETAIL).path("/img/3.jpg").build()
                        ))
                        .build()
        );
        final ResultActions resultActions = this.mockMvc.perform(
                post("/api/accommodation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        ).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    void 숙소이미지를_일부로_잘못만들어보자_400에러가나야함() throws Exception {
        String requestBody = objectMapper.writeValueAsString(
                AccommodationReq.Create.builder()
                        .name("")
                        .type(AccommodationType.HOTEL)
                        .locationGuideText("비산사거리에 위치한 호텔")
                        .geoLocation(new GeoLocation(37.39716397544742, 126.93087253698494))
                        .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                        .description("안양 최고의 호텔")
                        .imageList(Arrays.asList(
                                AccommodationReq.ImageOnCreate.builder().path("/img/1.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.THUMBNAIL).path("/img/2.jpg").build()
                                ,AccommodationReq.ImageOnCreate.builder().imageType(ImageType.DETAIL).path("/img/3.jpg").build()
                        ))
                        .build()
        );
        final ResultActions resultActions = this.mockMvc.perform(
                post("/api/accommodation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        ).andExpect(status().isBadRequest());
    }
}