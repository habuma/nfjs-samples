package habuma;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
	extends CrudRepository<Book, Long> {

	Iterable<SimpleBook> findSimpleBooksByFirstName(String fn);
	
	Book findByIsbn(String isbn);
	
}
