package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksCmhApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksCmhApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(BooksRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Knitting with Dog Hair", "Kendall", "Crolius"));
			repo.save(new Book("9876543210", "Crafting with Cat Hair", "Kaori", "Tsutaya"));
		};
	}
	
}
