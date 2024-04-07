package habuma.booksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class BooksClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksClientApplication.class, args);
    }


    @Bean
    ApplicationRunner go(BookApi api) {
        return args -> {

            api.addBook(new Book(
                    "123456789",
                    "Spring in Action",
                "Craig Walls"))
                .subscribe();

            Thread.sleep(1000);

            Flux<Book> booksFlux = WebClient.create("http://localhost:8080")
                    .get()
                    .uri("/books")
                    .retrieve()
                    .bodyToFlux(Book.class);

            booksFlux
                .map(book -> {
                    return new Book(
                            book.isbn(),
                            book.title().toUpperCase(),
                            book.author().toLowerCase());
                })
                .doOnNext(book -> {
                    System.out.println(" - " + book);
                })
                .subscribe();

            api.findByIsbn("5544332211")
                    .doOnNext(book -> {
                        System.out.println(" CAT HAIR BOOK:  " + book);
                    })
                    .subscribe();
        };
    }

    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory() {
        WebClient webClient = WebClient.create();
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(webClient);
        return HttpServiceProxyFactory.builder(webClientAdapter).build();
    }

    @Bean
    BookApi bookApi(HttpServiceProxyFactory factory) throws Exception {
        return factory.createClient(BookApi.class);
    }

}
