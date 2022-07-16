package habuma;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ReactorTests {

	@Test
	public void testFlux() {
		Flux.just("Apple", "Banana", "Cherry", "Date")
			.filter(f -> f.contains("e"))
			.map(f -> f.toUpperCase())
			.doOnNext(f -> {
				System.out.println("FRUIT:  " + f);
			})
			.subscribe()
			;
	}
	
	@Test
	public void testFlatMap() {
		Flux.just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
			.flatMap(player -> {
				sleep((int)(5 * Math.random()));
				return Mono.just(player)
//						.map(p -> {
//							try {
//								sleep((int)(5 * Math.random()));
//							} catch (Exception e) {}
//							return p;
//						})
						.doOnNext(p -> {
							System.out.println("THREAD: " + Thread.currentThread().getId());
						})
						.subscribeOn(Schedulers.parallel())
						;
			})
			.doOnNext(p -> {
				System.err.println(p);
			})
			.subscribe()
			;
		
		sleep(10000);
	}
	
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (Exception e) {}
	}
	
}
