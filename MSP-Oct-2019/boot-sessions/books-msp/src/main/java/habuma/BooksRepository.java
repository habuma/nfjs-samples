package habuma;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository 
		extends CrudRepository<Book, Long> {
	
	Book findByIsbn(String isbn);

}
