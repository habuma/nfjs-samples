package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookRepository repo;
	
	public BookController(BookRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Book findByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping(params="kendall")
	public Iterable<Book> kendallsBooks() {
		return repo.findKendallsBooks();
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
