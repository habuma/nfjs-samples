package habuma;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
	extends CrudRepository<Book, Long> {

	Optional<Book> findByIsbn(String isbn);
	
	@Query("select id, isbn, title, author "
			+ "from Book where author='Kendall Crolius'")
	Iterable<Book> kendallsBooks();
}
