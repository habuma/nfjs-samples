package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
	
	private final BookRepository bookRepo;

	@GetMapping
	public Flux<Book> allBooks() {
		return bookRepo.findAll()
				.map(book -> new Book(book.getIsbn(), book.getTitle().toUpperCase(), book.getAuthor().toLowerCase()));
	}
	
	@PostMapping
	public Mono<Book> saveABook(@RequestBody Book book) {
		return bookRepo.save(book);
	}
	
}
