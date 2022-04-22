package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookRepository repo;
	private MeterRegistry registry;

	public BookController(BookRepository repo, MeterRegistry registry) {
		this.repo = repo;
		this.registry = registry;
	}
	
	
	
	@GetMapping
	public Flux<Book> allBooks() {
		registry.counter("books", "allBooks", "count").increment();
		return repo.findAll();
	}
	
	@GetMapping(params="author")
	public Flux<Book> authorsBooks(@RequestParam("author") String author){
		return repo.findByAuthor(author);
	}
	
	@PostMapping
	public Mono<Book> saveABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
