package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TestingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingSpringApplication.class, args);
	}

	@Bean
	@Profile("testing")
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Knitting with Dog Hair", "Kendall Crolius"));
			repo.save(new Book("9876543210", "Crafting with Cat Hair", "Kaori Tsutaya"));
		};
	}
}
