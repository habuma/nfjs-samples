package habuma.graphbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class GraphBooksClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphBooksClientApplication.class, args);
    }

    @Bean
    ApplicationRunner go() {
        return args -> {
            HttpGraphQlClient qlClient = HttpGraphQlClient.builder()
                    .webClient(c -> {
                        c.baseUrl("http://localhost:8080/graphql");
                    })
                    .build();

            Mono<List<Book>> allBooks = qlClient.document("{ allBooks{isbn title author{firstName lastName} }}")
                    .retrieve("allBooks")
                    .toEntityList(Book.class);


            allBooks.doOnNext(books -> {
                        for (Book book : books) {
                            System.out.println(book);
                        }

                    })
                    .subscribe();

        };
    }

}
