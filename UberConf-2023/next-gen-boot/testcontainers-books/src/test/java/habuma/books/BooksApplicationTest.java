package habuma.books;

import org.springframework.boot.SpringApplication;

// this class can be run in the IDE directly or from the command line
// with `./mvnw spring-boot:test-run`
public class BooksApplicationTest {

    public static void main(String[] args) {
        SpringApplication
                .from(BooksApplication::main)
                .with(MyContainerConfiguration.class)
                .run(args);
    }

}
