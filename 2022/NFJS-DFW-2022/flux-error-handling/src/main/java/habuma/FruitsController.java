package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class FruitsController {

	@GetMapping("/fruits")
	public Flux<FruitResponse> fruits() {		
		return Flux.just("Apple", "Banana", "Carrot")
				.map(f -> new FruitResponse(f));
	}
	
}
