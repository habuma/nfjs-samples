package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository 
	extends CrudRepository<Book, Long>{

	Book findByIsbn(String isbn);
	
	SimpleBook findSimpleByIsbn(String isbn);
	
	@Query("from Book b where b.authorFirstName='Kendall'")
	Iterable<Book> findKendallsBooks();
	
}
