package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(UserRepository repo) {
		return (args) -> {
			repo.save(new AppUser("habuma", "password", "Craig Walls"));
			repo.save(new AppUser("venkat", "password", "Venkat Subramaniam"));
			repo.save(new AppUser("hinojosa", "password", "Daniel Hinojosa"));
		};
	}
	
}
