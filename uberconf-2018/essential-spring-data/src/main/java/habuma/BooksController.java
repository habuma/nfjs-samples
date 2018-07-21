package habuma;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

//@RestController
//@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {

	private final BookRepository repo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@GetMapping("/kendalls")
	public Iterable<Book> hairBooks() {
		repo.doSomethingStupid();
		
		return repo.findKendallsBooks();
	}
	
}
