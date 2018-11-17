package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfilesStlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilesStlApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(ProfileRepository repo, BookRepository bookRepo) {
		return args -> {
			repo.save(new Profile("habuma", "password", "Craig Walls", true));
			repo.save(new Profile("venkat", "password", "Venkat Subramaniam", true));
			repo.save(new Profile("nate", "password1", "Nate Schutta", false));
			
			bookRepo.save(new Book("1234567890", "Knitting with Dog Hair", "Kendall", "Crolius"));
			bookRepo.save(new Book("1928374560", "Collecting Camel Hair", "Kendall", "Jones"));
			bookRepo.save(new Book("9876543210", "Crafting with Cat Hair", "Tsuyana", "Smith"));
		};
	}
	
}
