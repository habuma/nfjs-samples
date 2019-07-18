package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository
	extends CrudRepository<Book, String> {

	Book findByIsbn(String isbn);
	
	@Query("{'author':'Kendall Crolius'}")
	Iterable<Book> kendallsBooks();
	
	void doSomething();
}
