package habuma.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
	
	private final BooksRepository repo;
	private final MeterRegistry registry;

	@GetMapping
	public Iterable<Book> allBooks() {
		registry.counter("habuma.books", "controller", "books").increment();

		return repo.findAll();
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
