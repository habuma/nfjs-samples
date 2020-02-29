package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TacotalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacotalkApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(TacoRepository tacoRepo) {
		return args -> {
			tacoRepo.save(new Taco("Trailer Park", "Flour", "Fried Chicken"));
			tacoRepo.save(new Taco("Democrat", "Corn", "Barbacoa"));
		};
	}

}
