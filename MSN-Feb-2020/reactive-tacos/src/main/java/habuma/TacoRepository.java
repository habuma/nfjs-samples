package habuma;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface TacoRepository extends ReactiveCrudRepository<Taco, Long> {

	@Query("select id, name, wrap, filling from Taco where wrap=:wrap")
	Flux<Taco> findByWrap(String wrap);
	
}
