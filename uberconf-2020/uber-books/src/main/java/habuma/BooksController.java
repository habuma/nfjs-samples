package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
	
	private final BookRepository bookRepo;
	
//	private final MeterRegistry registry;

	@GetMapping
	public Iterable<Book> allBooks() {
//		registry.counter("uberbooks", "greeting", "allBooks").increment();

		return bookRepo.findAll();
	}
	
	@PostMapping
	public Book saveABook(@RequestBody Book book) {
		System.out.println("SAVING A BOOK");
		return bookRepo.save(book);
	}
}
