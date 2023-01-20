package habuma;

import java.util.Optional;

import org.springframework.web.bind.annotation.ExceptionHandler;
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
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping("/kendalls")
	public Flux<Book> kendalls() {
		return repo.findKendallsBooks();
	}
	
	@PostMapping
	public Mono<Book> save(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@GetMapping("/fail")
	public Flux<String> fail() {
		return Flux.just("A", "B", "C")
				.map(s -> {
					if (s.equals("B")) {
						throw new RuntimeException("Crap happened");
					}
					return s;
				})
				.doOnError(x -> {
					System.out.println("ERROR:  " + x);
				});
	}
	
	@ExceptionHandler(RuntimeException.class)
	public Mono<String> handle(RuntimeException e) {
		return Mono.just("FAIL: " + e.getMessage());
	}
	
}
