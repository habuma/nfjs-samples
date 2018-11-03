package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/legacy/books")
@RequiredArgsConstructor
public class BooksController {
	
	private final BookRepository repo;

	@GetMapping
	public Iterable<Book> all() {
		return repo.findAll();
	}
	
	@GetMapping("/{isbn}")
	public Book byIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@GetMapping("/kendalls")
	public Iterable<Book> kendalls() {
		repo.doSomethingCompletelyDifferent();
		return repo.findKendallsBooks();
	}
	
	@GetMapping("/simple/{isbn}")
	public SimpleBook simpleBookIsbn(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
}
