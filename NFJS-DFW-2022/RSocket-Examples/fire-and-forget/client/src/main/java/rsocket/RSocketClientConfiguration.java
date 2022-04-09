package rsocket;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class RSocketClientConfiguration {

	private static final Logger log = LoggerFactory.getLogger(RSocketClientConfiguration.class);

	@Bean
	public ApplicationRunner sender(RSocketRequester.Builder requesterBuilder) {
		return args -> {
			RSocketRequester tcp = requesterBuilder.tcp("localhost", 7000);
			tcp
				.route("alert")
				.data(new Alert(
						Alert.Level.RED, "Craig", Instant.now()))
				.send()
				.subscribe();
			log.info("Alert sent");
		};
	}

}
