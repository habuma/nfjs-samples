package streeteats;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface FoodTruckEventRepository 
	extends ReactiveCrudRepository<FoodTruckEvent, Long> {

	Flux<FoodTruckEvent> findByFoodTruckId(Long truckId);
	
}
