package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UberBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberBooksApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Knitting with Dog Hair", "Kendall", "Crolius"));
			repo.save(new Book("9876543210", "Crafting with Cat Hair", "Kaori", "Tsutaya"));
			repo.save(new Book("1029384857", "Spring in Action, Fifth Edition", "Craig", "Walls"));
			repo.save(new Book("9876543210", "Spring Boot in Action", "Craig", "Walls"));
		};
	}

}
