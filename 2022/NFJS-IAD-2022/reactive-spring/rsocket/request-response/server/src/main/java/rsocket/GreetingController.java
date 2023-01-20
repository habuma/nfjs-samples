package rsocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Mono;

@Controller
public class GreetingController {

	private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

	@MessageMapping("greeting")
	public Mono<String> handleGreeting(Mono<String> greetingMono) {
		return greetingMono
			.doOnNext(greeting ->
				log.info("Received a greeting: {}", greeting))
			.map(greeting -> "Hello back to you!");
	}

	@MessageMapping("greeting/{name}")
	public Mono<String> handleGreeting(
			@DestinationVariable("name") String name,
			Mono<String> greetingMono) {

		return greetingMono
			.doOnNext(greeting ->
				log.info("Received a greeting from {} : {}", name, greeting))
			.map(greeting -> "Hello to you, too, " + name);
	}
}
