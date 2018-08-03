package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

	@Bean
	public CommandLineRunner loadData(BookRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Knitting with Dog Hair", "Kendall Crolius"));
			repo.save(new Book("9876543210", "Crafting with Cat Hair", "Kaori Tsutaya"));

		};
	}
	
}
