package habuma;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.micrometer.observation.annotation.Observed;
import reactor.core.publisher.Mono;

@Observed(name="books")
public interface BookRepository 
      extends ReactiveCrudRepository<Book, Long> {

  Mono<Book> findByIsbn(String isbn);
  
}
