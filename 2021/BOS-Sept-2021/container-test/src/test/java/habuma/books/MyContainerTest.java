package habuma.books;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;

public class MyContainerTest {
	
	private static final Logger log = LoggerFactory.getLogger(MyContainerTest.class);
	
	private static final String HELLO_IMAGE = "habuma/hello-k8s";
	
	@Container
    private final GenericContainer<?> topLevelContainer = new GenericContainer<>(HELLO_IMAGE)
    	.withExposedPorts(8080)
    	.withLogConsumer(new Slf4jLogConsumer(log));

	@BeforeEach
	public void setup() throws Exception {
		topLevelContainer.start();
	}
	
	@Test
	public void dummy() {
		Integer firstMappedPort = topLevelContainer.getFirstMappedPort();
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject(
				"http://localhost:{port}/hello", String.class, firstMappedPort);
		assertThat(response).isEqualTo("Hello!");
	}

}
