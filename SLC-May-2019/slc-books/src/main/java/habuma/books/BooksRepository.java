package habuma.books;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository 
	extends CrudRepository<Book, Long> {

}
