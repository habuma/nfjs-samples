package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		Mono<String> map = Mono.just("Hello, world!")
				.map(s -> {
					String result = s.toUpperCase();
					System.out.println("UPPER CASING NOW");
					return result;
				});
		System.out.println("FINISHED...RETURNING MONO");
		return map;
	}
	
	@GetMapping("/bye")
	public String bye() {
		String result = "Goodbye";
		System.out.println("UPPER CASING NOW");
		result = result.toUpperCase();
		System.out.println("FINISHED...RETURNING STRING");
		return result;
	}
	
	@GetMapping("/hellos")
	public Flux<Message> hellos() {
		Flux<Message> hellos = 
				Flux.just("Hello", "Buenos Dias", "Hola", "Aloha")
				.flatMap(s -> {
					Message message = new Message();
					message.setMessage(s);
					return Mono.just(message)
							.map(m -> {
								m.setMessage(m.getMessage().toUpperCase());
								return m;
							})
							.subscribeOn(Schedulers.parallel());
				});
		return hellos;
	}
	
}
