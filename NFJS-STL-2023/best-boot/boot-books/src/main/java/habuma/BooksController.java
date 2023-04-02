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
	private ObservationRegistry obsReg;

	public BooksController(BookRepository repo, ObservationRegistry obsReg) {
		this.repo = repo;
		this.obsReg = obsReg;
	}
	
	@GetMapping
	@Observed(name="allBooks")
	public Flux<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn)
				.switchIfEmpty(Mono.error(new UnknownBookException(isbn)));
	}
	
	@PostMapping
	public Mono<Book> saveABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
