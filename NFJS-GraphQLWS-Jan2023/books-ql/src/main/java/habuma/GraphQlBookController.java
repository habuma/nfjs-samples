package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQlBookController {
	
	private final BookRepository bookRepo;
	private AuthorRepository authorRepo;
	
	public GraphQlBookController(BookRepository bookRepo, AuthorRepository authorRepo) {
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
	}

	@QueryMapping("allBooks")
	public Iterable<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	@QueryMapping("bookByIsbn")
	public Book byIsbn(@Argument("isbn") String isbn) {
		return bookRepo.findByIsbn(isbn);
	}
	
	@QueryMapping("booksByAuthorLastName")
	public Iterable<Book> byLastName(@Argument("lastName") String lastName) {
		return bookRepo.findByAuthorLastName(lastName);
	}
	
	@MutationMapping("createBook")
	public Book createBook(@Argument("book") Book book) {
		System.out.println("**** " + book.getIsbn() );
		Author saved = authorRepo.save(book.getAuthor());
		book.setAuthor(saved);
		return bookRepo.save(book);
	}
	
	@MutationMapping("deleteBook")
	public Book deleteBook(@Argument("isbn") String isbn) {
		// fetch the book so that we can know its ID and then return it before it goes away forever
		Book toDelete = bookRepo.findByIsbn(isbn);
		if (toDelete != null) {
			bookRepo.deleteById(toDelete.getId());
		}
		return toDelete;
	}
	
}
