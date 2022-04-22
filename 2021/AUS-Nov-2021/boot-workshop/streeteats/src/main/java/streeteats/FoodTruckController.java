package streeteats;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trucks")
public class FoodTruckController {

	private final FoodTruckRepository repo;
	
	public FoodTruckController(FoodTruckRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<FoodTruck> allTrucks() {
		return repo.findAll();
	}
	
	@PostMapping
	public Mono<FoodTruck> saveATruck(@RequestBody FoodTruck truck) {
		return repo.save(truck);
	}
	
}
