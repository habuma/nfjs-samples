package habuma;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class ReactiveTests {

	@Test
	public void testFlux() throws Exception {
		Flux.interval(Duration.ofSeconds(1))
			.take(5)
			.filter(n -> (n%2 == 0))
			.map(n -> "COUNTER:  " + n)
			.doOnNext(d -> {
						System.out.println(d);
					})
			.log()
			.subscribe();
		
		
		
		
		Thread.sleep(10000);
	}
	
}
