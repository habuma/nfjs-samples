package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	private BookRepository repo;
	private AuthorRepo authorRepo;

	public BookController(BookRepository repo, AuthorRepo authorRepo) {
		this.repo = repo;
		this.authorRepo = authorRepo;
	}
	
	@MutationMapping("addBook")
	public Book addBook(@Argument("book") Book book) {
		
		Author author = book.getAuthor();
		Author savedAuthor = authorRepo.save(author);
		
		book.setAuthor(savedAuthor);
		
		return repo.save(book);
	}
	
}
