package habuma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

	@Bean
	HttpServiceProxyFactory httpServiceProxyFactory() {
	  WebClient webClient = WebClient.create();
	  WebClientAdapter webClientAdapter = WebClientAdapter.forClient(webClient);
	  return HttpServiceProxyFactory.builder(webClientAdapter).build();
	}
	
	@Bean
	public BookClient bookClient(HttpServiceProxyFactory factory) 
			throws Exception {
		return factory.createClient(BookClient.class);
	}
	
}
