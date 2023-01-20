package habuma;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientTest {

	@Test
	public void go() throws Exception {
		
		WebClient wc = WebClient.builder().build();
		
		wc.get()
			.uri("http://localhost:8080/hello")
			.exchangeToMono(r -> {
				return r.bodyToMono(String.class);
			})
			.subscribe(b -> {
				System.err.println(b);
			});
		
	}
	
}
