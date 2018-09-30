package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

	private final BookRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping(params="author")
	public Iterable<Book> byAuthor(@RequestParam("author") String author) {
		return repo.findByAuthor(author);
	}
	
	@GetMapping("/kendalls")
	public Iterable<Book> kendallsBooks() {
		repo.doSomethingDifferent();
		
		return repo.findKendallsBooks();
	}
	
	@PostMapping
	public Book saveABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
