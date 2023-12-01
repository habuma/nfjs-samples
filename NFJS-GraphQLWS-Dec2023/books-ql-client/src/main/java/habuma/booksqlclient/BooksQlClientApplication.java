package habuma.booksqlclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class BooksQlClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksQlClientApplication.class, args);
    }

    @Bean
    public ApplicationRunner go() {
        return args -> {
            HttpGraphQlClient graphQl = HttpGraphQlClient.builder()
//                    .url("http://localhost:8080/graphql")
                    .webClient(c -> {
                        c.baseUrl("http://localhost:8080/graphql");
                    })
                    .build();

            Mono<String> helloMono = graphQl
                    .document("{hello}")
                    .retrieve("hello")
                    .toEntity(String.class);

            helloMono
                    .doOnNext(System.out::println)
                    .subscribe();

            Mono<List<Book>> booksMono = graphQl.documentName("allBooks")
                    .retrieve("allBooks")
                    .toEntityList(Book.class);

            booksMono
                    .doOnNext(bookList -> {
                        bookList.stream().forEach(book -> {
                            System.out.println(" --> " + book.getIsbn() + " : " + book.getTitle());
                        });
                    })
                    .subscribe();

        };
    }

}
