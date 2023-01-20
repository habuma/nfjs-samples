package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphController {

	private BookRepository repo;
	private AuthorRepository authorRepo;

	public BooksGraphController(BookRepository repo, AuthorRepository authorRepo) {
		this.repo = repo;
		this.authorRepo = authorRepo;
	}
	
	@MutationMapping("addBook")
	public Book addBook(@Argument Book book) {
		Author author = book.getAuthor();
		Author savedAuthor = authorRepo.save(author);
		
		return repo.save(book);
	}
	
}
