package habuma.reactivebooks;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository
        extends ReactiveCrudRepository<Book, Long> {

    Mono<Book> findByIsbn(String isbn);

    @Query("select id, isbn, title, author from Book where author='Kendall Crolius'")
    Flux<Book> kendallsBooks();

    Mono<SimpleBook> findSimpleByIsbn(String isbn);

}
