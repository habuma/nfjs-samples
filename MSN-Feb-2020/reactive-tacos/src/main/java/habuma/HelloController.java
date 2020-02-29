package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("Hello world!");
	}
	
	@GetMapping(path="/counter", produces="application/stream+json")
	public Flux<Long> counter() {
		return Flux.interval(Duration.ofSeconds(1));
	}
	
}
