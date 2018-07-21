package habuma;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveCrudRepository<Person, String> {
	
	@Tailable
	Flux<Person> findWithTailableCursorBy();

}
