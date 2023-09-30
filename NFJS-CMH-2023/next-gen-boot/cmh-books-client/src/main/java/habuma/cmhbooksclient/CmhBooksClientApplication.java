package habuma.cmhbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class CmhBooksClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmhBooksClientApplication.class, args);
    }

    @Bean
    ApplicationRunner go(BookApi api) {
        return args -> {
            api.getAllBooks()
                .subscribe(book -> System.out.println(book));
        };
    }

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient webClient = WebClient.create();
        WebClientAdapter adapter = WebClientAdapter.forClient(webClient);
        return HttpServiceProxyFactory.builder(adapter).build();
    }

    @Bean
    BookApi bookApi(HttpServiceProxyFactory factory) throws Exception {
        return factory.createClient(BookApi.class);
    }

}
