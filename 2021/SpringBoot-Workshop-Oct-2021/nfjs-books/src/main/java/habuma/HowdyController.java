package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RestController
public class HowdyController {

	@GetMapping("/howdy")
	public Mono<String> howdy() {
		return Mono.just("Howdy!")
				.map(in -> in.toUpperCase());
	}
	
	@GetMapping("/fruits")
	public Flux<String> fruits() {
		return Flux.fromArray(new String[] {"Apple", "Orange", "Grape"})
				.flatMap(in -> Mono.just(in.toLowerCase())
						.subscribeOn(Schedulers.parallel()));
	}
	
}
