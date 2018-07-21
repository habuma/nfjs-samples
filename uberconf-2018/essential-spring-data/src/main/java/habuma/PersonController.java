package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

	private final PersonRepository repo;
	
	@GetMapping(produces="application/stream+json")
	public Flux<Person> allPeople() {
		return repo.findWithTailableCursorBy();
	}
	
	@PostMapping
	public Mono<Person> save(@RequestBody Person person) {
		return repo.save(person);
	}
}
