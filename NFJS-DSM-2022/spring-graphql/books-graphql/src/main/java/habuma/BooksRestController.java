package habuma;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksRestController {

	private BookRepository repo;

	public BooksRestController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Iterable<Book> books() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> byId(@PathVariable("id") Long id) {
		return repo.findById(id);
	}
	
	@GetMapping(params = "author")
	public Iterable<Book> byAuthor(@RequestParam("author") String authorName) {
		String firstName = authorName.split(" ")[0];
		String lastName = authorName.split(" ")[1];
		
		return repo.findByAuthorFirstNameAndAuthorLastName(firstName, lastName);
	}
	
}
