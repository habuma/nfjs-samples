package habuma;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	Iterable<Book> findByAuthor(String a);
	
	Book findByIsbn(String isbn);
	
}
