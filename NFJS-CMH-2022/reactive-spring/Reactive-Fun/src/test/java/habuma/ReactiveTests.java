package habuma;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ReactiveTests {

	@Test
	public void simpleCreationTest() {
		
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Cherry");
		
		Flux<String> fruitFlux = Flux.fromIterable(fruits);
		
		fruitFlux
			.map(f -> f.toUpperCase())
			.doOnNext(f -> {
				System.out.println("FRUIT: " + f);
			})
			.subscribe();
	}
	
	@Test
	public void flatMap() throws Exception {
		
		List<Player> players = new ArrayList<>();
		players.add(new Player("Michael", "Jordan"));
		players.add(new Player("Scottie", "Pippen"));
		players.add(new Player("Steve", "Kerr"));
		
		Flux<Player> playerFlux = Flux.fromIterable(players);
		
		playerFlux
			.flatMap(p -> Flux.just(p)
					.map(p1 -> {
						try {
							System.out.println("THREAD: " + Thread.currentThread().getId());
							Thread.sleep(Math.round(Math.random()*10));
						} catch (Exception e) {}
						return p1.getFirstName() + " " + p1.getLastName();
					}).subscribeOn(Schedulers.parallel())
					)
			.doOnNext(p -> {
				System.out.println(p);
			})
			.subscribe();
			
		Thread.sleep(10000);
		
	}
	
	
}
