package habuma.mspbooksclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MspBooksClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MspBooksClientApplication.class, args);
    }

    @Bean
    ApplicationRunner go() {
        return args -> {
            List<Book> book =
                RestClient.create("http://localhost:8080")
                        .get()
                        .uri("/books")
                        .retrieve()
                        .body(new ParameterizedTypeReference<List<Book>>() { });

            System.out.println("Got book: " + book);

        };
    }

}
