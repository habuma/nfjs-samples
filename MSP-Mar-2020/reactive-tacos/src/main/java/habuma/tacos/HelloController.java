package habuma.tacos;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("Hello");
	}
	
	@PostMapping(path="/hi")
	public Mono<String> hi(@RequestBody Mono<Who> who) {
		return who
			.map(w -> "Hi, " + w.getName());
	}
	
	@GetMapping("/counter")
	public Flux<Long> counter() {
		return Flux.interval(Duration.ofSeconds(1));
	}
	
	@Data
	public static class Who {
		private String name;
	}
	
	
}
