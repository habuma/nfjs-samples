package habuma.booksgraphqlclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BooksGraphQlClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksGraphQlClientApplication.class, args);
    }

    @Bean
    ApplicationRunner go() {
        return args -> {
            HttpGraphQlClient graphql = HttpGraphQlClient.builder()
                    .webClient(c -> {
                        c.baseUrl("http://localhost:8080/graphql");
                    })
                    .build();

            graphql.document("{hello}")
                    .retrieve("hello")
                    .toEntity(String.class)
                    .doOnNext(s -> {
                        System.out.println("HELLO: " + s);
                    })
                    .subscribe();

//            graphql.document("{allBooks{isbn title}}")
//                    .retrieve("allBooks")
//                    .toEntity(Book[].class)
//                    .doOnNext(s -> {
//                        for(int i=0; i<s.length; i++) {
//                            System.out.println("BOOK RESPONSE: " + s[i]);
//                        }
//                    })
//                    .subscribe();

            graphql.documentName("allBooksQuery")
                    .retrieve("allBooks")
                    .toEntity(Book[].class)
                    .doOnNext(s -> {
                        for(int i=0; i<s.length; i++) {
                            System.out.println("BOOK RESPONSE: " + s[i]);
                        }
                    })
                    .subscribe();

            Thread.sleep(5000);
        };
    }

}
