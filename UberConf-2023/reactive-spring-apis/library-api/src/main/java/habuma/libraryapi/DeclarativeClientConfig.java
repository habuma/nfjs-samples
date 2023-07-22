package habuma.libraryapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class DeclarativeClientConfig {

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient webClient = WebClient.create();
        WebClientAdapter webClientAdapter =
                WebClientAdapter.forClient(webClient);

        return HttpServiceProxyFactory
                .builder(webClientAdapter)
                .build();
    }

    @Bean
    public BookApiClient bookApiClient(HttpServiceProxyFactory factory) {
        return factory.createClient(BookApiClient.class);
    }

}
