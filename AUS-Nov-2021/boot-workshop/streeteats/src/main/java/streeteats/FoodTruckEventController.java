package streeteats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/events")
public class FoodTruckEventController {

	private FoodTruckEventRepository repo;

	public FoodTruckEventController(FoodTruckEventRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<FoodTruckEvent> allEvents() {
		return repo.findAll();
	}
	
	@GetMapping("/truck/{truckId}")
	public Flux<FoodTruckEvent> byTruck(
			@PathVariable("truckId") Long truckId) {
		return repo.findByFoodTruckId(truckId);
	}
	
	@PostMapping
	public Mono<FoodTruckEvent> saveEvent(
			@RequestBody FoodTruckEvent event) {
		return repo.save(event);
	}
	
}
