package habuma;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ReactiveTests {

	@Test
	public void testSomethingStupidSimple() {
		Flux<String> fruitFlux = Flux.just("Apple", "Banana", "Cherry");
		
		fruitFlux
			.map(fruit -> fruit.toUpperCase())
			.doOnNext(fruit -> {
				System.out.println("FRUIT: " + fruit);
			})
			.subscribe();
	}
	
	@Test
	public void basketball() {
		
		Flux<String> players = Flux.just("Michael Jordan", "Scottie Pippen", "Steve Kerr");
		
		players
			.flatMap(player -> {
				System.err.println(" ** " + Thread.currentThread().getId());
				return Mono.just(player.toLowerCase())
						.doOnNext(x -> {
							System.err.println(" -- " + Thread.currentThread().getId());
						})
						.subscribeOn(Schedulers.parallel());
			})
			.subscribe(player -> {
				System.out.println(player + " :: " + Thread.currentThread().getId());
			});
		
		
	}
	
	private void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
