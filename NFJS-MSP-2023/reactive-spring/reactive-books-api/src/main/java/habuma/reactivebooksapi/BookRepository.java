package habuma.reactivebooksapi;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface BookRepository
        extends ReactiveCrudRepository<Book, Long>,
        ReactiveQueryByExampleExecutor<Book> {

    Mono<Book> findByIsbn(String isbn);

    Mono<SimpleBookRecord> findSimpleByIsbn(String isbn);

//    @Query("select id, isbn, title, author from Book where author = 'Kendall Crolius'")
//    Flux<Book> kendallsBooks();


}
