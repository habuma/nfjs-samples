package habuma.reactivebooksapi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveBooksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveBooksApiApplication.class, args);
    }

    @Bean
    ApplicationRunner loader(BookRepository repo) {
        return args -> {
            repo.save(new Book(null, "1122334455", "Knitting with Dog Hair", "Kendall Crolius"))
                    .subscribe();
            repo.save(new Book(null, "5544332211", "Crafting with Cat Hair", "Kaori Tsutaya"))
                    .subscribe();
            System.out.println(" BOOKS LOADED!");
        };
    }

}
