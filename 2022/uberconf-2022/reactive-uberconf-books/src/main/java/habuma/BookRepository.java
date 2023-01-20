package habuma;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

public interface BookRepository 
	extends ReactiveCrudRepository<Book, String> {

	Mono<Book> findByIsbn(String isbn);

	Mono<SimpleBook> findSimpleByIsbn(String isbn);

}
