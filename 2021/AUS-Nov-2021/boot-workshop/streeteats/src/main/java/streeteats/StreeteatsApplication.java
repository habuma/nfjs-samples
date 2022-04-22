package streeteats;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class StreeteatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreeteatsApplication.class, args);
	}

	@Bean
	@Profile("development")
	public ApplicationRunner dataLoader(FoodTruckRepository repo) {
		return args -> {
			FoodTruck romos = new FoodTruck();
			romos.setName("Romo's Street Tacos");
			romos.setCategory(FoodTruck.Category.MEXICAN);

			FoodTruck torchys = new FoodTruck();
			torchys.setName("Torchy's Tacos");
			torchys.setCategory(FoodTruck.Category.MEXICAN);

			FoodTruck burgerPassport = new FoodTruck();
			burgerPassport.setName("Burger Passport");
			burgerPassport.setCategory(FoodTruck.Category.BURGERS);

			repo.save(romos).subscribe();
			repo.save(torchys).subscribe();
			repo.save(burgerPassport).subscribe();
		};
	}
	
}
