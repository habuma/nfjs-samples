package habuma;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	Book findByIsbn(String isbn);
	
	SimpleBook findSimpleBookByIsbn(String isbn);
	
	
	Iterable<Book> findByAuthor(String author);
	
	
	
}
