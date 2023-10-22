package habuma.reactivebooksmongoapi;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository
        extends ReactiveCrudRepository<Book, String> {

    @Tailable
    Flux<Book> findBy();

    Mono<Book> findByIsbn(String isbn);

}
