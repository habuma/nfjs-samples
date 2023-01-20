package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("Hello world!");
	}
	
	@GetMapping("/hellos")
	public Flux<Greeting> hellos() {
		return Flux.just("Hello", "Aloha", "Hola", "Bon Jour")
				.map(g -> {
					Greeting greeting = new Greeting();
					greeting.setMessage(g);
					return greeting;
				});
	}
	
	@GetMapping("/counter")
	public Flux<Greeting> counter() {
		return Flux.interval(Duration.ofSeconds(2))
				.map(i -> {
					Greeting greeting = new Greeting();
					greeting.setMessage("Hello " + i);
					return greeting;
				})
				.take(10);
	}
	
	
}
