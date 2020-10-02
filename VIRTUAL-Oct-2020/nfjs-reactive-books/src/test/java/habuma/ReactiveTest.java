package habuma;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class ReactiveTest {

//	@Test
	public void testReactiveStuff() throws Exception {

		Long[] values = new Long[] {1L,2L,3L,4L,5L,6L};
		
		Flux.fromArray(new Long[] {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L})
			.doOnNext(n -> System.out.println("NEXT:  " + n))
			.take(5)
			.doOnNext(n -> System.out.println("TAKE:  " + n))
			.map(n -> "NUMBER IS: " + n)
			.doOnNext(n -> System.out.println("MAPPED:  " + n))
			.subscribe();
		
		Thread.sleep(10000);
	}
	
}
