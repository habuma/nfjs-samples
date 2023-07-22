package habuma.reactivebooks;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository
        extends ReactiveCrudRepository<Book, String> {

    Mono<Book> findByIsbn(String isbn);

    @Query("{author:'Kendall Crolius'}")
    Flux<Book> kendallsBooks();

    Mono<SimpleBook> findSimpleByIsbn(String isbn);

    @Tailable
    Flux<Book> findByTitleLike(String titleSubstring);
}
