package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends 
	CrudRepository<Book, String>, BookRepositoryExtras {
	
	Iterable<Book> findByTitleContains(String tc);

	@Query("{'author':'Kendall Crolius'}")
	Iterable<Book> findKendallsBooks();
		
}
