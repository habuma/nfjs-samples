package habuma;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {

	Flux<Book> findAll();
	
	Mono<Book> findByIsbn(String isbn);
	
}
