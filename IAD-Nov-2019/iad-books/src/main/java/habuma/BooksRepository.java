package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository 
	extends CrudRepository<Book, Long> {

	Book findByIsbn(String isbn);
	
	SimplePublication findSimpleByIsbn(String isbn);
	
	@Query("from Book b where b.author.firstName = 'Kendall' and b.author.lastName='Crolius'")
	Book findBooksByKendallCrolius();
	
}
