package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface BooksRepository 
	extends CrudRepository<Book, Long> {
	
	SimpleBook findSimpleById(Long id);
	
	Book findByIsbn(String isbn);
	
	Iterable<Book> findByAuthorLastName(String a);
	
	@RestResource(exported = false)
	@Override
	void delete(Book entity);
	
	@RestResource(exported = false)
	@Override
	void deleteAll();

	@RestResource(exported = false)
	@Override
	void deleteById(Long id);
	
	@RestResource(exported = false)
	@Override
	void deleteAll(Iterable<? extends Book> entities);
	
}
