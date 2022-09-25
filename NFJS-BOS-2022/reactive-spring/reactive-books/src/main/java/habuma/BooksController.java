package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	private BookRepository repo;

	public BooksController(BookRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public Flux<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		System.out.println("************");
		return repo.findByIsbn(isbn);
	}
	
}
