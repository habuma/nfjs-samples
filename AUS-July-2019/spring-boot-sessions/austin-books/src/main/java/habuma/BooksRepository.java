package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, String> {
	
	Book findByIsbn(String isbn);
	
	SimpleBook findSimpleByIsbn(String isbn);
	
	@Query("{'authorFirstName':'Kendall'}")
	Iterable<Book> findKendallsBooks();
	
}
