package habuma.tacos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tacos")
@RequiredArgsConstructor
public class TacoApiController {
	
	private final TacoRepository tacoRepo;

	@GetMapping
	public Iterable<Taco> tacos() {
		return tacoRepo.findAll();
	}
	
	@PostMapping
	public Taco saveATaco(@RequestBody Taco taco) {
		return tacoRepo.save(taco);
	}
	
}
