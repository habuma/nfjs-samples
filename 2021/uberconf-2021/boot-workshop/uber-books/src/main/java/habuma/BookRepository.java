package habuma;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
	extends CrudRepository<Book, Long> {

	Iterable<Book> findByAuthor(String author);
	
	Iterable<Book> findByAuthorAndTitleLike(String author, String tl);
		
}
