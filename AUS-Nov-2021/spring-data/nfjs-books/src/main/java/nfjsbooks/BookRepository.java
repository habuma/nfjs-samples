package nfjsbooks;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
	extends CrudRepository<Book, String> {
	
	Iterable<Book> findByIsbn(String isbn);

	Iterable<SimpleBook> findSimpleByIsbn(String isbn);

	Iterable<Book> findByAuthorAndTitleLikeOrIsbnStartsWith(
			String a, String tl, String isbnSW);
	
	@Query("{'author':'Kendall Crolius'}")
	Iterable<Book> findKendallsBooks();
	
	
}
