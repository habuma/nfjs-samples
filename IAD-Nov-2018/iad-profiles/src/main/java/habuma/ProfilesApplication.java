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
			repo.save(new Profile("habuma", "password", "Craig", "Walls", "Shhhhh!!!!"));
			repo.save(new Profile("schutta", "password", "Nate", "Schutta", "Don't tell"));
			repo.save(new Profile("kousen", "password", "Ken", "Kousen", "Secrets here"));
			repo.save(new Profile("sletten", "password", "Brian", "Sletten", "Keep it to yourself"));
			repo.save(new Profile("johnson", "password", "Jonathan", "Johnson", "Kubernetes is cool"));
		};
	}
}
