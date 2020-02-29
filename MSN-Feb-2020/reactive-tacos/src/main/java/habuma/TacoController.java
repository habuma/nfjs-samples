package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tacos")
@Slf4j
public class TacoController {

	private final TacoRepository repo;
	
	@GetMapping
	public Flux<Taco> tacos() {
		return repo.findAll();
	}
	
	@GetMapping(params="wrap")
	public Flux<Taco> tacosByWrap(@RequestParam("wrap") String wrap) {
		return repo.findByWrap(wrap);
	}
	
	@PostMapping
	public Mono<Taco> saveTaco(@RequestBody Mono<Taco> tacoMono) {
		log.info("BEFORE");
		Mono<Taco> response = tacoMono
			.doOnNext(t -> log.info("TACO: " + t))
			.flatMap(taco -> {
				log.info("DURING");
				return repo.save(taco);
			})
			.doOnNext(t -> log.info("TACO (AFTER): " + t))

		;
		log.info("AFTER");
		return response;
	}
	
}
