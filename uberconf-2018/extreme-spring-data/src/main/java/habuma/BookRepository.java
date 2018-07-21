package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository extends 
	CrudRepository<Book, Long>, BookRepositoryExtras,
	QueryByExampleExecutor<Book> {
	
	
	Book findByIsbn(String isbn);
	
	Iterable<Book> findByAuthorFirstNameAndAuthorLastName(String f, String l);
	
	Iterable<Book> findByTitleContains(String tc);

	@Query("from Book b where b.authorFirstName='Kendall' and b.authorLastName='Crolius'")
	Iterable<Book> findKendallsBooks();
	
	Iterable<SimpleBook> findSimpleBy();
		
}
