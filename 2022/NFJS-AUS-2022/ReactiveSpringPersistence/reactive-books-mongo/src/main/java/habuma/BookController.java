package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{id}")
	public Mono<Book> byId(@PathVariable String id) {
		return repo.findById(id);
	}
	
	@GetMapping(path="/author", params = "author", produces = "application/stream+json")
	public Flux<Book> byAuthor(@RequestParam("author") String author) {
		System.out.println("!");
		return repo.findByAuthor(author);
	}
	
	@PostMapping
	public Mono<Book> save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
