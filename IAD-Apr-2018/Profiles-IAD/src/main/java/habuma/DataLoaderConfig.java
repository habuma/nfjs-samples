package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

	@Bean
	public CommandLineRunner dataLoader(UserProfileRepository repo) {
		
		return args -> {
			repo.save(new UserProfile("habuma", "Craig", "Walls", "Spring"));
			repo.save(new UserProfile("ken", "Ken", "Kousen", "Groovy"));
			repo.save(new UserProfile("sipe", "Ken", "Sipe", "Security"));
			repo.save(new UserProfile("nate", "Nate", "Schutta", "JavaScript"));
		};
		
	}
	
}
