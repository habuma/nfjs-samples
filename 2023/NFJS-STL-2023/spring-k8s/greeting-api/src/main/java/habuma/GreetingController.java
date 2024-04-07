package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("Hello k8s!");
	}

	@GetMapping("/goodbye")
	public Mono<String> bye() {
		return Mono.just("Goodbye!");
	}

}
