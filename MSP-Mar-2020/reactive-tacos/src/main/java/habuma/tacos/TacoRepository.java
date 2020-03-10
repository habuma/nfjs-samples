package habuma.tacos;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface TacoRepository 
	extends ReactiveCrudRepository<Taco, String> {

	@Tailable
	Flux<Taco> findByWrap(String wrap);
	
}
