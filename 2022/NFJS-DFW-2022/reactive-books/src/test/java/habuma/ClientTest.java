package habuma;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class ClientTest {

	@Test
	public void testClient() throws Exception {
		
		Mono<String> responseBody = 
				WebClient.create("https://google.com")
			.method(HttpMethod.GET)
			.exchangeToMono(response -> {
				return response.bodyToMono(String.class);
			});
		responseBody.subscribe(
				b -> {
					System.out.println(b);
				});
		
		Thread.sleep(5000);
	}
	
}
