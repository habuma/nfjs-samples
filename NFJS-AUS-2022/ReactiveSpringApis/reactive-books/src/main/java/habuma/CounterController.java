package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class CounterController {

	@GetMapping(path="/counter", produces = "application/stream+json")
	public Flux<CounterRecord> counter() {
		Flux<CounterRecord> flux =
				Flux.interval(Duration.ofSeconds(1))
				.map(n -> new CounterRecord(n, System.currentTimeMillis()))
				.take(5);
		return flux;
	}
	
}
