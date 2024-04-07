package habuma.reactivebooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveBooksClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveBooksClientApplication.class, args);
    }

    @Bean
    ApplicationRunner go() {
        return args -> {

            String isbn="1122334455";


            Flux<Book> bookFlux = WebClient.create("http://localhost:8080")
                    .get()
                    .uri("/books/{isbn}", isbn)
                    .retrieve()
                    .bodyToFlux(Book.class);

            bookFlux.subscribe(System.out::println);

        };
    }

}
