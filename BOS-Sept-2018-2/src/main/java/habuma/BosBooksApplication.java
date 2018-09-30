package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BosBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BosBooksApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Spring in Action", "Craig Walls"));
		};
	}
	
}
