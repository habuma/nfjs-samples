package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {

  private BookRepository repo;
  private ObservationRegistry observationRegistry;
  
  public BooksController(BookRepository repo, ObservationRegistry observationRegistry) {
    this.repo = repo;
    this.observationRegistry = observationRegistry;
  }

// Explicitly wrap a method in an observation
  @GetMapping
  public Flux<Book> allBooks() {
    return Observation.createNotStarted("allBooks", observationRegistry)
          .observe(this::allBooksObserved);
  }
  
  Flux<Book> allBooksObserved() {
    return repo.findAll();
  }
  
  // Rely on AOP to wrap the method for observability
  @GetMapping("/{isbn}")
  @Observed(name="bookByIsbn")
  public Mono<Book> bookByIsbn(@PathVariable("isbn") String isbn) {
    return repo.findByIsbn(isbn)
        .switchIfEmpty(Mono.error(new BookNotFoundException(isbn)));
  }
  
  @PostMapping
  public Mono<Book> saveABook(@RequestBody Book book) {
    return repo.save(book);
  }

}
