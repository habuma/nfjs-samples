package habuma.books;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// this main class can be run in the IDE or from the command line with
// `./mvnw spring-boot:run`
@SpringBootApplication
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }

    @Bean
    ApplicationRunner go(BookRepository repo) {
        return args -> {
            repo.save(
                    new Book(
                            "1122334455",
                            "Knitting with Dog Hair",
                            "Kendall Crolius"));

            repo.save(
                    new Book(
                            "2233445566",
                            "Crafting with Cat Hair",
                            "Kaori Tsutaya"));
        };
    }
}
