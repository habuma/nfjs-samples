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
	
//	@QueryMapping("allBooks")
//	public Iterable<Book> allBooks() {
//		System.out.println("**** FETCHING ALL BOOKS ****");
//		return repo.findAll();
//	}
	
	@MutationMapping("createBook")
	public Book createBook(@Argument Book book) {
		Author author = book.getAuthor();
		author = authorRepo.save(author);
		
		System.out.println(" **** SAVING A BOOK ****");
		return repo.save(book);
	}
}
