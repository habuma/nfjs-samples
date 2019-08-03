package habuma;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

	private final BooksRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/kendallsBooks")
	public Iterable<Book> booksByKendall() {
		return repo.findKendallsBooks();
	}
	
	@GetMapping("/{isbn}")
	public SimpleBook bookById(@PathVariable("isbn") String isbn) {
		return repo.findSimpleByIsbn(isbn);
	}
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
