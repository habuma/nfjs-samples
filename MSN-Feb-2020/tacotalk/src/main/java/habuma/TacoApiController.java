package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tacos")
@RequiredArgsConstructor
public class TacoApiController {

	private final TacoRepository tacoRepo;
	
	@GetMapping
	public Iterable<Taco> allTacos() {
		return tacoRepo.findAll();
	}
	
}
