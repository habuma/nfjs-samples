package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository 
		extends CrudRepository<Book, String>,
				BookRepoExtras {

	// from Book b where b.author=?
	Iterable<Book> findByAuthor(String author);
	
	Book findByIsbn(String isbn);
	
	@Query("{'author':'Kendall Crolius'}")
	Iterable<Book> findKendallsBooks();
			
//	findByIsbnAndTitleLikeOrAuthorContainsAndTitleStartingWith(fjdfjfhjkfhdjkfhkj)
	
//	Iterable<Book> findByAgeLessThan(int age);
	
//	Iterable<Book> findByCopyrightDateLessThan(Date date)
	
//	Iterable<Book> findByPublisher_Address_ZipCode(String zc);
	
}
