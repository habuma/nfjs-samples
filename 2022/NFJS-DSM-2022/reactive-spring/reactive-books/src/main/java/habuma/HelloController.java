package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		Mono<String> helloMono = 
				Mono.just("Hello world")
					.doOnNext(x -> {
						System.out.println("ABOUT TO UPPERCASE");
					})		
					.map(s -> s.toUpperCase())
					.doOnNext(x -> {
						System.out.println("FINISHED UPPERCASING");
					});
		
		System.out.println("RETURNING THE MONO");
		
		return helloMono;
	}
	
	
	@GetMapping(path="/count", produces = "application/stream+json")
	public Flux<CountEntry> counter() {
		return Flux.interval(Duration.ofSeconds(1))
				.flatMap(x -> {
					return 
						Flux.just(new CountEntry((long) x, System.currentTimeMillis()))
							.doOnNext(c -> {
								try {
									Thread.sleep((long)(Math.random() * 2000));
								} catch (Exception e) {}
							}).subscribeOn(Schedulers.parallel());
				});
	}
	
	
	
}
