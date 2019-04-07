package habuma.books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	 
	@Bean
	public CommandLineRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Knitting With Dog Hair", "Kendall Crolius"));
			repo.save(new Book("9876543210", "Crafting With Cat Hair", "Kaori Tsutaya"));
			repo.save(new Book("1928373650", "Spring in Action, Fifth Edition", "Craig Walls"));
		};
	}
	
}
