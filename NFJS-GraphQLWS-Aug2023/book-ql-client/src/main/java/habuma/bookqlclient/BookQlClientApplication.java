package habuma.bookqlclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class BookQlClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookQlClientApplication.class, args);
    }

    @Bean
    ApplicationRunner go() {
        return args -> {
            HttpGraphQlClient qlClient = HttpGraphQlClient.builder()
                    .url("http://localhost:8080/graphql")
                    .build();

            Mono<String> helloMono = qlClient.document("{ hello }")
                    .retrieve("hello")
                    .toEntity(String.class);

            helloMono
                    .doOnNext(s -> System.out.println("The response was: " + s))
                    .subscribe();

            Mono<List<Book>> entityList = qlClient.documentName("allBooks")
                    .retrieve("allBooks")
                    .toEntityList(Book.class);

            entityList
                    .doOnNext(bookList -> {
                        for (Book book: bookList) {
                            System.out.println("The book is: " + book.getTitle());
                        }
                    })
                    .subscribe();
        };
    }

}
