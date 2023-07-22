package habuma.reactivebooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@SpringBootApplication
public class ReactiveBooksClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveBooksClientApplication.class, args);
    }

    @Bean
    ApplicationRunner go(BooksClient booksClient) {
        return args -> {
            System.out.println("Hello, reactive books!");

//            RestTemplate rest = new RestTemplate();
//            Book book = rest.getForObject(
//                    "http://localhost:8080/books/{id}", Book.class, 1);
//            System.out.println("Book: " + book);


            WebClient
                    .create("http://localhost:8080")
                    .get()
                    .uri("/books/{id}", 1)
                    .retrieve()
                    .bodyToMono(Book.class)
                    .subscribe(book -> System.out.println("Book: " + book));


            booksClient.getBookById(2L)
                .subscribe(b -> System.out.println("2nd Book: " + b));



            Thread.sleep(5000);
        };
    }
}
