package habuma;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class LearningTest {

	@Test
	public void testInterval() throws Exception{
		Flux.interval(Duration.ofSeconds(2))
			.take(3)
			.subscribe(c -> {
				System.out.println(c);
			});
		
		Thread.sleep(100000);
	}
	
}
