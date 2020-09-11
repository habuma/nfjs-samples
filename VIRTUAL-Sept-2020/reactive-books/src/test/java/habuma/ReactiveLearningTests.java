package habuma;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class ReactiveLearningTests {

	@Test
	public void testReactiveStuff() {
		Mono.just("Hello")
				.doOnNext(text -> {
					System.out.print("--->  " + text);
				})
				.subscribe();

	}
	
}
