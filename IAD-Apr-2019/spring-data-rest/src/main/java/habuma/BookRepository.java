package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = SimpleBook.class)
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByIsbn(String isbn);
	
	SimpleBook findSimpleByIsbn(String isbn);
	
	@Override
//	@RestResource(exported = false)
	void deleteById(Long id);
	
	@Override
//	@RestResource(exported = false)
	void delete(Book entity);
	
}
