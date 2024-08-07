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
		return repo.findAll();
	}
	
//	@GetMapping("/{id}")
//	public Mono<Book> byId(@PathVariable("id") String id) {
//		return repo.findById(id);
//	}
	
	@GetMapping("/{isbn}")
	public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping(path="/{isbn}", params = "simple")
	public Mono<SimpleBook> bySimpleIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@GetMapping("/kendalls")
	public Flux<Book> kendallsBooks() {
		return repo.findKendallsBooks();
	}
	
	@PostMapping
	public Mono<Book> saveBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
