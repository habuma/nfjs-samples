package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeaProfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaProfilesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(ProfileRepository repo) {
		return args -> {
			repo.save(new Profile("habuma", "password", "Craig", "Walls"));
			repo.save(new Profile("schutta", "password", "Nate", "Schutta"));
			repo.save(new Profile("kousen", "password", "Ken", "Kousen"));
			repo.save(new Profile("sletten", "password", "Brian", "Sletten"));
			repo.save(new Profile("johnson", "password", "Jonathan", "Johnson"));
		};
	}
}
