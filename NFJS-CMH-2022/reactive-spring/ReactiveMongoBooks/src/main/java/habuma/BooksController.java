package habuma;

import org.springframework.web.bind.annotation.DeleteMapping;
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
public class BooksController {

	BookRepository repo;
	
	public BooksController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<Book> allBooks() {
		return repo.findAll();
	}
	
//	@GetMapping("/{id}")
//	public Mono<Book> byId(@PathVariable("id") Long id) {
//		return repo.findById(id);
//	}

	@GetMapping("/{isbn}")
	public Mono<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping(path="/{isbn}", params = "simple")
	public Mono<SimpleBook> simpleByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@GetMapping("/kendalls")
	public Flux<Book> kendallsBooks() {
		return repo.kendallsBooks();
	}
	
	@GetMapping("/spring")
	public Flux<Book> springBooks() {
		return repo.findByTitleLike("Spring");
	}
	
	@PostMapping
	public Mono<Book> save(@RequestBody Book book) {
		return repo.save(book);
	}
	
	
	@DeleteMapping("/{id}")
	public Mono<Void> deleteByid(@PathVariable("id") String id) {
		return repo.deleteById(id);
	}
}
