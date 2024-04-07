package habuma.booksapi;

import org.springframework.boot.SpringApplication;

public class BooksApiApplicationTest {

    public static void main(String[] args) {
//        SpringApplication.run(BooksApiApplication.class, args);
        SpringApplication
                .from(BooksApiApplication::main)
                .with(MyContainersConfiguration.class)
                .run(args);
    }

}
