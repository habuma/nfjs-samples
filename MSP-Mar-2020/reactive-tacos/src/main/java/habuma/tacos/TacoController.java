package habuma.tacos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tacos")
@RequiredArgsConstructor
public class TacoController {
	
	private final TacoRepository repo;

	@GetMapping
	public Flux<Taco> allTacos() {
		return repo.findAll();
	}
	
	@GetMapping(path="/bywrap", params="wrap", produces="application/stream+json")
	public Flux<Taco> byWrap(@RequestParam("wrap") String wrap) {
		return repo.findByWrap(wrap)
				.map(taco -> {
					Taco responseTaco = new Taco(taco.getName().toUpperCase(), taco.getWrap(), taco.getFilling());
					responseTaco.setId(taco.getId());
					return responseTaco;
				});
	}
	
	@PostMapping
	public Mono<Taco> saveTaco(@RequestBody Mono<Taco> tacoMono) {
		return tacoMono
				.flatMap(taco -> {
					return repo.save(taco);
				});
	}
	
}
