package habuma.tacos;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository 
	extends CrudRepository<Taco, Long> {

	Iterable<Taco> findByWrap(String wrap);
	
}
