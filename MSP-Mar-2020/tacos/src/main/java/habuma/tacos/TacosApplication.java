package habuma.tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacosApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(TacoRepository repo) {
		return args -> {
			repo.save(new Taco("Democrat", "Corn Tortilla", "Barbacoa"));
			repo.save(new Taco("Trailer Park", "Flour Tortilla", "Fried Chicken"));
			repo.save(new Taco("Tipsy Chick", "Flour Tortilla", "Bourbon glazed chicken"));
		};
	}
	
}
