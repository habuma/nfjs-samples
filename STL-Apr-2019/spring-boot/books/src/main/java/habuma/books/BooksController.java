package habuma.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

	private final BookRepository repo;
	
	private final MeterRegistry meterRegistry;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		
		meterRegistry.counter("habuma.books", "allbooks", "requests").increment();
		
		return repo.findAll();
	}
	
}
