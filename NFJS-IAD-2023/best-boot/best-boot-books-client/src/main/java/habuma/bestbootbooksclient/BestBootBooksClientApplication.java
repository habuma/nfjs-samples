package habuma.bestbootbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class BestBootBooksClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestBootBooksClientApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(BookClient bookClient) {
        return args -> {
            Book book = bookClient.findBookByIsbn("1122334455");
            System.out.println("Found book: " + book);
        };
    }

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient webClient = WebClient.create();
        WebClientAdapter webClientAdapter =
                WebClientAdapter.forClient(webClient);
        return HttpServiceProxyFactory
                .builder(webClientAdapter).build();
    }

    @Bean
    public BookClient bookClient(HttpServiceProxyFactory factory) throws Exception {
        return factory.createClient(BookClient.class);
    }
}
