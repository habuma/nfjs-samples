package books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CijugBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(CijugBooksApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner startup(BookRepository repo) {
		return args -> {
			System.out.println("STARTING UP!");
			repo.save(new Book("1111122222", "Knitting With Dog Hair", "Kendall Crolius"));
			repo.save(new Book("2222233333", "Crafting With Cat Hair", "Kaori Tsutaya"));
		};
	}

}
