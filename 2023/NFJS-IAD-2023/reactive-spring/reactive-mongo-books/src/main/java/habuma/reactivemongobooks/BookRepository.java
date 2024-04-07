package habuma.reactivemongobooks;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository
        extends ReactiveCrudRepository<Book, String>,
        ReactiveQueryByExampleExecutor<Book> {

    @Tailable
    Flux<TitleAndAuthor> findBy();

    Mono<Book> findByIsbn(String isbn);

}
