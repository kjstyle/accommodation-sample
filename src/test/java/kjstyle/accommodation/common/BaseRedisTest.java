package kjstyle.accommodation.common;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;

public abstract class BaseRedisTest extends BaseTest {
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
}