package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class CounterController {

	@GetMapping(path="/counter", produces="application/stream+json")
	public Flux<CounterObject> counter() {
		return Flux.interval(Duration.ofSeconds(1))
//				.take(5)
				.map(number -> new CounterObject("VALUE: " + number));
	}
	
}
