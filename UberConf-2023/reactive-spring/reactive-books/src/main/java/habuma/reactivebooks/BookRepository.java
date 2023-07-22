package habuma.reactivebooks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookRepository
        extends ReactiveCrudRepository<Book, Long> {
}
