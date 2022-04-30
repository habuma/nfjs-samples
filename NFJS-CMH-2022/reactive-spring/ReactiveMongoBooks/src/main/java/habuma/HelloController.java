package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("Hello reactive world!")
				.map(s -> {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {}
					return s.toUpperCase();
				});
	}
	
}
