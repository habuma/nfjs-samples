package rsocket;
import java.net.URI;

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
			RSocketRequester requester = requesterBuilder.websocket(
					URI.create("ws://localhost:8080/rsocket"));

			requester
				.route("greeting")
				.data("Hello RSocket!")
				.retrieveMono(String.class)
				.subscribe(response -> log.info("Got a response: {}", response));

			String who = "Craig";
			requester
				.route("greeting/{name}", who)
				.data("Hello RSocket!")
				.retrieveMono(String.class)
				.subscribe(response -> log.info("Got a response: {}", response));
		};
	}

}
