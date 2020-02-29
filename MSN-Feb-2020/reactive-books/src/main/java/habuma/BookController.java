package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final BookRepository repo;

	@GetMapping
	public Flux<Book> books() {
		return repo.findAll();
	}
	
	@GetMapping(params="author")
	public Flux<Book> booksByAuthor(@RequestParam("author") String author) {
		return repo.findByAuthor(author);
	}
	
}
