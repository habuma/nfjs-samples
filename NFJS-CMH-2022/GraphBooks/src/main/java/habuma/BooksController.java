package habuma;

import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

	private BookRepository repo;
	private AuthorRepository authorRepo;

	public BooksController(BookRepository repo, AuthorRepository authorRepo) {
		this.repo = repo;
		this.authorRepo = authorRepo;
	}
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Book> byId(@PathVariable("id") Long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public Book save(@RequestBody Book book) {
		return repo.save(book);
	}
	
	
	@QueryMapping(name="bookByIsbn")
	public Book byIsbn(@Argument String isbn) {
		System.err.println("***************** FINDING BY ISBN");
		return repo.findByIsbn(isbn);
	}
	
	@MutationMapping(name="createBook")
	public Book mutateBook(@Argument("input") BookInput bookInput) {
		Author author = authorRepo.save(new Author(bookInput.getAuthorFirstName(), bookInput.getAuthorLastName()));
		return repo.save(new Book(bookInput.getIsbn(), bookInput.getTitle(), author));
	}

}
