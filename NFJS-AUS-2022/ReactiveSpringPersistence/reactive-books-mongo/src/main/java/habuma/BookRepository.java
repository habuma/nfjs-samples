package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface BookRepository 
	extends ReactiveCrudRepository<Book, String> {

	@Query("{'author':'Kendall Crolius'}")
	Flux<Book> kendallsBooks();
	
	@Tailable
	Flux<Book> findByAuthor(String author);
	
}
