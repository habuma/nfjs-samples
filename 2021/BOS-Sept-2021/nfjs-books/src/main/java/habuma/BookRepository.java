package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
		extends CrudRepository<Book, Long> {

	Book findByIsbn(String isbn);
	
	@Query("from Book b where b.author='Kendall Crolius'")
	Iterable<Book> findKendallsBooks();
	
}
