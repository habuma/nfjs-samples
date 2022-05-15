package habuma;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ReactorTests {

	@Test
	public void basicFluxTest() {
		Flux<String> fruitFlux = 
				Flux.fromArray(new String[] {"Apple", "Banana", "Cherry"});
		
		fruitFlux
			.map(f -> {
				long threadId = Thread.currentThread().getId();
				System.out.println("[" + threadId + "] UPPERCASING");
				return f.toUpperCase();
			})
			.doOnNext(f -> {
				long threadId = Thread.currentThread().getId();
				System.out.println("[" + threadId + "] GOT A FRUIT: " + f);
			})
			.subscribe();
	}
	
	@Test
	public void flatMapTest() {
		
		Flux<String> bullsFlux = Flux.fromArray(new String[] {
				"Michael Jordan",
				"Scottie Pippen",
				"Steve Kerr",
				"Dennis Rodman"
		});
		
		bullsFlux
			.flatMap(p -> {
				return 
					Mono.just(p.toUpperCase())
						.doOnNext(x -> {
							try {
								Thread.sleep((long)(Math.random()*100));
							} catch (Exception e) {}
							long id = Thread.currentThread().getId();
							System.err.println("THREAD: " + id);
						})
						.subscribeOn(Schedulers.parallel());
			})
			.subscribe(p -> {
				System.out.println("PLAYER: " + p);
			});
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
