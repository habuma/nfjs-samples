package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class CounterController {

	@GetMapping(path="/counter")
	public Flux<Message> counter() {
		return Flux.interval(Duration.ofSeconds(1))
			.map(i -> {
				Message message = new Message();
				message.setMessage("count: " + i);
				return message;
			});
		
	}
	
}
