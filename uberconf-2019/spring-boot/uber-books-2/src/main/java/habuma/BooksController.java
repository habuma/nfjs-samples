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
		repo.doSomething();
		return repo.kendallsBooks();
	}
	
	@GetMapping("/{isbn}")
	public Book bookById(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@PostMapping
	public Book saveABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
