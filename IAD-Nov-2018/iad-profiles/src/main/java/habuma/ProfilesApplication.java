package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(ProfileRepository repo) {
		return args -> {
			repo.save(new Profile("habuma", "Craig", "Walls"));
			repo.save(new Profile("schutta", "Nate", "Schutta"));
			repo.save(new Profile("kousen", "Ken", "Kousen"));
			repo.save(new Profile("sletten", "Brian", "Sletten"));
			repo.save(new Profile("johnson", "Jonathan", "Johnson"));
		};
	}
}
