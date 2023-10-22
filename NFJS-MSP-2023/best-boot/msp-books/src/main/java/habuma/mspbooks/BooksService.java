package habuma.mspbooks;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BooksService {

    private final BookRepository repo;
    private final ObservationRegistry observationRegistry;

    public BooksService(BookRepository repo, ObservationRegistry observationRegistry) {
        this.observationRegistry = observationRegistry;
        this.repo = repo;
    }

    public Mono<Book> findByIsbn(String isbn) {
        return Observation
                .createNotStarted("bookByIsbn", observationRegistry)
                .observe(() -> findByIsbnTarget(isbn));
    }

    public Mono<Book> findByIsbnTarget(String isbn) {
        return repo.findByIsbn(isbn)
                .switchIfEmpty(Mono.error(new BookNotFoundException(isbn)));
    }
    
    
}
