package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends 
	CrudRepository<Book, String>, BookRepoExtras {
	
	Book findByIsbn(@Param("abcd") String isbn);

	SimpleBook findSimpleByIsbn(String isbn);

	@Query("{'authorFirstName':'Kendall','authorLastName':'Crolius'}")
	Iterable<Book> findKendallsBooks();
	
}
