package habuma.booksql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphQlController {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    public BooksGraphQlController(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @MutationMapping("addBook")
    public Book addBook(@Argument("title") String title,
                        @Argument("isbn") String isbn,
                        @Argument("authorFirstName") String authorFirstName,
                        @Argument("authorLastName") String authorLastName) {
        // dumb way of doing this, but it works. Smarter way left as exercise for attendees
        Author savedAuthor = authorRepo.save(new Author(authorFirstName, authorLastName));
        return bookRepo.save(new Book(isbn, title, savedAuthor));
    }

//    @QueryMapping("allBooks")
//    public Iterable<Book> allBooks() {
//        return bookRepo.findAll();
//    }

//    @QueryMapping("byIsbn")
//    public Book byIsbn(@Argument("isbn") String isbn) {
//        System.err.println("QUERYING BY ISBN: " + isbn);
//        return bookRepo.findByIsbn(isbn);
//    }

}
