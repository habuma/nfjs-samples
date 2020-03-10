package habuma.tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ReactiveTacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveTacosApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(TacoRepository repo, MongoOperations mongoOps) {
		return args -> {
			CollectionOptions options = CollectionOptions.empty().capped().size(50);
			mongoOps.createCollection("taco", options);
			repo.save(new Taco("Democrat", "Corn Tortilla", "Barbacoa")).subscribe(System.out::println);
			repo.save(new Taco("Trailer Park", "Flour Tortilla", "Fried Chicken")).subscribe(System.out::println);
			repo.save(new Taco("Tipsy Chick", "Flour Tortilla", "Bourbon glazed chicken")).subscribe(System.out::println);
		};
	}
}
