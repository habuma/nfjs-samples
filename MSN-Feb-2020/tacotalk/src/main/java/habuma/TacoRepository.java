package habuma;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository 
		extends CrudRepository<Taco, String> {

	Iterable<Taco> findByWrap(String wrap);
	
}
