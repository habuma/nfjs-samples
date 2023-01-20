package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/books")
public class RestBookController {

	private BookRepository repo;

	public RestBookController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
