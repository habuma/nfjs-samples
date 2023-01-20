package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

	private BookRepository repo;

	public BookController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<Book> allBooks() {
		return repo.findAll()
				.map(book -> {
					return new Book();
				});
	}
	
	@GetMapping("/{isbn}")
	public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@PostMapping
	public Mono<Book> save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
