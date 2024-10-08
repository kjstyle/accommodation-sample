package kjstyle.accommodation.testcontainers;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import kjstyle.accommodation.common.BaseEsTest;
import kjstyle.accommodation.domain.enums.AccommodationType;
import kjstyle.accommodation.domain.enums.ParkingType;
import kjstyle.accommodation.domain.model.Accommodation;
import kjstyle.accommodation.domain.model.GeoLocation;
import kjstyle.accommodation.domain.model.ParkingInfo;
import kjstyle.accommodation.domain.service.AccommodationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/*
### ES 관련 특이사항
* 사전설정 필요
  * Reuse가 지원하지 않아서 이렇게 해줘야된다고하는데...옳지 않아~~~ 다른 방법 찾는 중
  * 사용자 홈 디렉토리(~)에 .testcontainers.properties라는 이름의 파일을 생성 (나는 이미 존재하는 파일이었음)
  * 이 파일에 아래 내용을 추가 (이 설정은 Testcontainers가 컨테이너를 재사용할 수 있도록 허용하는 옵션)
  * 만약 안넣어주면?? -> 테스트 실패함 ㅡㅡ;
```
testcontainers.reuse.enable=true
```
 */
public class EsContainerTest extends BaseEsTest {

    public static final String INDEX_NAME = "accommodation";

    @Autowired
    ElasticsearchClient esClient;

    @Autowired
    AccommodationService accommodationService;

    @Test
    void ES에_인덱스를_생성하고_인덱스에_데이터를_넣고_조회해보기() throws IOException {

        // 참고 : https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/getting-started-java.html
        // (2024.10.08) 8.15 기준 가이드

        boolean indexExists = esClient.indices().exists(e -> e.index(INDEX_NAME)).value();
        if (!indexExists) {
            esClient.indices().create(c -> c.index(INDEX_NAME));
        }

        Accommodation accommodation1 = Accommodation.builder()
                .id(1L)
                .name("비산호텔")
                .type(AccommodationType.HOTEL)
                .locationGuideText("비산사거리에 위치한 호텔")
                .geoLocation(new GeoLocation(37.39716397544742, 126.93087253698494))
                .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                .description("안양 최고의 호텔")
                .build();

        Accommodation accommodation2 = Accommodation.builder()
                .id(2L)
                .name("종각호텔")
                .type(AccommodationType.HOTEL)
                .locationGuideText("종각역 근처")
                .geoLocation(new GeoLocation(37.2890, 126.1234))
                .parkingInfo(new ParkingInfo(true, ParkingType.MACHINE))
                .description("종각역 근처 최고의 비지니스 호텔")
                .build();

        IndexResponse response1 = esClient.index(i -> i
                .index(INDEX_NAME)
                .id(String.valueOf(accommodation1.getId()))
                .document(accommodation1)
        );

        IndexResponse response2 = esClient.index(i -> i
                .index(INDEX_NAME)
                .id(String.valueOf(accommodation2.getId()))
                .document(accommodation2)
        );

        GetResponse<Accommodation> document1 = esClient.get(g -> g
                        .index(INDEX_NAME)
                        .id("1"),
                Accommodation.class
        );

        Accommodation accommodation1FromES = document1.source();
        Assertions.assertThat(accommodation1FromES.getId()).isEqualTo(accommodation1.getId());
        Assertions.assertThat(accommodation1FromES.getName()).isEqualTo(accommodation1.getName());

        GetResponse<Accommodation> document2 = esClient.get(g -> g
                        .index(INDEX_NAME)
                        .id("2"),
                Accommodation.class
        );
    }
}
