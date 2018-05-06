package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CmhUserProfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmhUserProfilesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(UserProfileRepository repo) {
		return (args) -> {
			repo.save(new UserProfile("habuma", "password", "Craig", "Walls"));
			repo.save(new UserProfile("maisy", "password", "Maisy", "Walls"));
			repo.save(new UserProfile("hinojosa", "password", "Daniel", "Hinojosa"));
			repo.save(new UserProfile("raju", "password", "Raju", "Gandhi"));
		};
	}

}
