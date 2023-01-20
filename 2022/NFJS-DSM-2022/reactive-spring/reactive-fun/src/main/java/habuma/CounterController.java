package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class CounterController {

	@GetMapping("/count")
	public Flux<Long> counter() {
		return Flux.interval(Duration.ofSeconds(2));
	}
	
}
