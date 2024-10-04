package kjstyle.accommodation.testcontainers;


import kjstyle.accommodation.common.BaseTest;
import kjstyle.accommodation.infra.RedisCrudService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * testconatainers 기본 테스트
 *   - 로컬에 도커를 먼저 실행시켜놔야함 (전제)
 */
@Testcontainers
public class RedisContainerTest extends BaseTest { // TODO : 추상클래스로 변경해서 상속받아 사용하도록 해야할 듯

    @Autowired
    private RedisCrudService redisCrudService;

    static final String REDIS_IMAGE = "redis:latest";
    static final GenericContainer<?> REDIS_CONTAINER;

    static {
        REDIS_CONTAINER = new GenericContainer<>(REDIS_IMAGE)
                .withExposedPorts(6379)
                .withReuse(true); // withReuse(true) 옵션을 설정하면, 테스트 컨테이너가 한 번 시작된 후 재사용될 수 있음을 의미함. 동일한 컨테이너를 계속 사용하기 때문에, 테스트가 매번 새 컨테이너를 시작하는 오버헤드를 줄일 수 있음
        REDIS_CONTAINER.start();
    }

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.data.redis.host", REDIS_CONTAINER::getHost); // spring.redis가 아니라 srping.data.redis로 바뀌었다. 예제코드 무지성 복붙 주의!!
        registry.add("spring.data.redis.port", () -> "" + REDIS_CONTAINER.getMappedPort(6379));
        registry.add("spring.data.redis.password", () -> "1234");
    }

    @Test
    void 레디스_SET_GET_테스트 () {
        redisCrudService.setKey("test-key", "test-value");
        String valueFromRedis = redisCrudService.getKey("test-key");
        Assertions.assertThat(valueFromRedis).isEqualTo("test-value");
    }
}