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
public class BookController {

	private BookRepository repo;

	public BookController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
//	@GetMapping("/{id}")
//	public Optional<Book> byId(@PathVariable("id") Long id) {
//		return repo.findById(id);
//	}
	
	@GetMapping("/{isbn}")
	public Book byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}

	@GetMapping(path="/{isbn}", params="simple")
	public SimpleBook simpleByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleBookByIsbn(isbn);
	}

	
	@PostMapping
	public Book saveABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
