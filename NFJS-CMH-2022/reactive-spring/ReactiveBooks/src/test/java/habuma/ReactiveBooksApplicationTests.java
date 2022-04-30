package habuma;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;

@SpringBootTest
class ReactiveBooksApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void doesSubscribeBlock() throws Exception {
		Flux.interval(Duration.ofSeconds(2))
			.doOnNext(c -> {
				System.out.println("NEXT: " + c + "  --- " + Thread.currentThread().getId());
			})
			.subscribe();
			
		System.err.println("FINISHED : " + Thread.currentThread().getId());
		
		Thread.sleep(10000);
	}
}
