package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookQlController {

	private BookRepository repo;
	private AuthorRepository authorRepo;

	public BookQlController(BookRepository repo, AuthorRepository authorRepo) {
		this.repo = repo;
		this.authorRepo = authorRepo;
	}
	
	@QueryMapping(name="bookByIsbn")
	public Book byIsbn(@Argument("isbn") String isbn) {
		System.out.println("CALLING BY ISBN");
		return repo.findByIsbn(isbn);
	}
	
	@MutationMapping(name="createAuthor")
	public Author saveAuthor(@Argument("author") Author author) {
		return authorRepo.save(author);
	}
	
}
