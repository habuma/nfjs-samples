package rsocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Mono;

@Controller
public class AlertController {

	private static final Logger log = LoggerFactory.getLogger(AlertController.class);

	@MessageMapping("alert")
	public Mono<Void> setAlert(Mono<Alert> alertMono) {
		return alertMono
			.doOnNext(alert ->
				log.info("{} alert ordered by {} at {}",
						alert.getLevel(),
						alert.getOrderedBy(),
						alert.getOrderedAt())
			)
			.thenEmpty(Mono.empty());
	}
	
}
