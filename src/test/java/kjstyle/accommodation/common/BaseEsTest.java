package kjstyle.accommodation.common;


import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class BaseEsTest extends BaseRedisTest {
    static final String ES_IMAGE = "docker.elastic.co/elasticsearch/elasticsearch:8.10.0";
    static final GenericContainer<?> ES_CONTAINER;

    static {
        ES_CONTAINER = new GenericContainer<>(ES_IMAGE)
                .withEnv("discovery.type", "single-node") // 테스트니까 싱글노드로
                .withEnv("xpack.security.enabled", "false") // 인증 없이 Elasticsearch에 접근할 수 있게
                .withExposedPorts(9200)
                .withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
                        new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(9200), new ExposedPort(9200)))))
                .withReuse(true); // 컨테이너를 재사용하도록 지정
        ES_CONTAINER.start();
    }

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.elasticsearch.uris", () -> "http://" + ES_CONTAINER.getHost() + ":" + ES_CONTAINER.getMappedPort(9200));
    }
}
