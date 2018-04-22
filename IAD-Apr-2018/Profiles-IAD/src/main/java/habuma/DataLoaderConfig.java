package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

	@Bean
	public CommandLineRunner dataLoader(UserProfileRepository repo) {
		
		return args -> {
			repo.save(new UserProfile("habuma", "password", "Craig", "Walls", "Spring"));
			repo.save(new UserProfile("ken", "password", "Ken", "Kousen", "Groovy"));
			repo.save(new UserProfile("sipe", "password", "Ken", "Sipe", "Security"));
			repo.save(new UserProfile("nate", "password", "Nate", "Schutta", "JavaScript"));
		};
		
	}
	
}
