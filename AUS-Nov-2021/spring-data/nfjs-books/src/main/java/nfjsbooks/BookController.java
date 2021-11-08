package nfjsbooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oldapi/books")
public class BookController {

	private BookRepository repo;

	public BookController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Iterable<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping("/simple/{isbn}")
	public Iterable<SimpleBook> bySimpleIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@GetMapping("/kendalls")
	public Iterable<Book> kendallsBooks() {
		return repo.findKendallsBooks();
	}
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
