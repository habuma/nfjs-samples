package habuma;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class WebClientTest {

	@Test
	public void webClientTest() throws Exception {
		
		WebClient webClient = WebClient.builder().build();
		
		Mono<String> waitTimeFlux = webClient
			.get()
			.uri("https://api.themeparks.wiki/preview/parks/{park}/waittime",
					"WaltDisneyWorldMagicKingdom")
			.retrieve()
			.bodyToMono(String.class);
		
		waitTimeFlux
			.subscribe(x -> {
				System.out.println("WAIT TIME:  " + x + "\n");
			});
		
		Thread.sleep(10000);
	}
	
}
