package habuma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@MutationMapping(name = "createBook")
	public Book createBook(@Argument(name="book") Book bookIn) {
		Author author = authorRepo.save(bookIn.getAuthor());
		bookIn.setAuthor(author);
		return bookRepo.save(bookIn);
	}
	
}
