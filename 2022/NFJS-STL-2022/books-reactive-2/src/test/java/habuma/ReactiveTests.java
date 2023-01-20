package habuma;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ReactiveTests {

	@Test
	public void createFluxFromList() {
		System.out.println("MAIN THREAD: " + Thread.currentThread().getId());

		List<String> fruits = new ArrayList<>();
		fruits.add("orange");
		fruits.add("apple");
		fruits.add("kumquat");
		fruits.add("kiwi");
		
		Flux.fromIterable(fruits)
			.map(f -> {
				if (f.startsWith("a")) {
					throw new RuntimeException();
				}
				System.out.println("A THREAD: " + Thread.currentThread().getId());
				return f.toUpperCase();
			})
			.filter(f -> {
				System.out.println("B THREAD: " + Thread.currentThread().getId());
				return f.startsWith("K");
			})
			.doOnNext(f -> {
				System.out.println("C THREAD: " + Thread.currentThread().getId());
				System.out.println("FRUIT:  " + f);
			})
			.doOnError(e -> {
				System.err.println("ERROR: " + e.getMessage());
			})
//			.parallel()
			.subscribeOn(Schedulers.parallel())
			.subscribe(c -> {},
					e-> {}
			);
		
	}
	
}
