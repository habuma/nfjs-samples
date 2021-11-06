package streeteats;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FoodTruckRepository 
	extends ReactiveCrudRepository<FoodTruck, Long> {
}
