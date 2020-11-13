package habuma;

import java.util.Optional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final BookRepository repo;
	
	private final MeterRegistry meter;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		meter.counter("nfjs", "requests", "books", "foo", "bar").increment();

		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> bookById(@PathVariable("id") Long id) {
		return repo.findById(id);
	}
	
	@GetMapping("/isbn/{isbn}")
	public Book bookByIsbn(@PathVariable("isbn") String isbn) {
		return repo.findByIsbn(isbn);
	}
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
	@Scheduled(fixedDelay = 5000)
	public void doSomethingEverySoOften() {
		System.out.println("PING");
	}
	
	
}
