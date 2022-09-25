package habuma;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ReactiveFunTests {

	@Test
	public void simpleFlux() {
		Flux<String> fruitFlux = 
				Flux.just("Apple", "Banana", "Cherry");
		
		fruitFlux
			.map(fruit -> fruit.toUpperCase())
			.doOnNext(fruit -> {
				long threadId = Thread.currentThread().getId();
				System.out.println("FRUIT: " + fruit + "; " + threadId);
			})
			.map(fruit -> fruit.toLowerCase())
			.doOnNext(fruit -> {
				long threadId = Thread.currentThread().getId();
				System.err.println("FRUIT: " + fruit + "; " + threadId);
			})
			.subscribe();
	}
	
	@Test
	public void basketball() {
		Flux<String> players = Flux.just("Michael Jordan", "Larry Bird", "Magic Johnson");
		
		players
			.flatMap(player -> {
				return Mono.just(player)
						.map(p -> {
							sleep((int)(Math.random() * 10000));
							return p.toUpperCase();
						})
						.subscribeOn(Schedulers.parallel());
			})
			.subscribe(player -> {
				System.out.println("PLAYER: " + player);
			});
				
		sleep(20000);
	}
	
	private void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
