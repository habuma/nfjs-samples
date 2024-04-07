package habuma.booksapi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.dialect.JdbcPostgresDialect;

@SpringBootApplication
public class BooksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApiApplication.class, args);
    }

    @Bean
    JdbcPostgresDialect dialect() {
        return new JdbcPostgresDialect();
    }

    @Bean
    ApplicationRunner go(BookRepository repo) {
        return args -> {
            repo.save(new Book(
                            null,
                            "1122334455",
                            "Knitting with Dog Hair",
                          "Kendall Crolius"));

            repo.save(new Book(
                            null,
                            "2233445566",
                            "Crafting with Cat Hair",
                            "Kaori Tsutaya"));

        };
    }
}
