package habuma;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	private BookRepository repo;

	public BooksController(BookRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Optional<Book> byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping(path="/{isbn}", params = "simple")
	public Optional<SimpleBook> bySimpleIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
