package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

	@Bean
	public CommandLineRunner dataLoader(ProfileRepository repo) {
		
		return args -> {
			repo.save(new Profile("habuma", "Craig", "Walls"));
			repo.save(new Profile("ken", "Ken", "Kousen"));
			repo.save(new Profile("sipe", "Ken", "Sipe"));
			repo.save(new Profile("nate", "Nate", "Schutta"));
		};
		
	}
	
}
