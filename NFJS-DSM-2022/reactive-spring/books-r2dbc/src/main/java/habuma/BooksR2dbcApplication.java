package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksR2dbcApplication.class, args);
	}

	@Bean
	public ApplicationRunner loader(BookRepository repo) {
		return args -> {
			repo.save(new Book(null, "1111122222", "Knitting with Dog Hair", "Kendall Crolius")).subscribe();
			repo.save(new Book(null, "3333344444", "Crafting with Cat Hair", "Kaori Tsutaya")).subscribe();
		};
	}
	
}
