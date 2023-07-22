package habuma.graphqlbooks;

import org.springframework.data.domain.Example;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksGraphqlController {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    public BooksGraphqlController(BookRepository bookRepo, AuthorRepository authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @MutationMapping("addBook")
//    @PreAuthorize("#{isAuthenticated() and hasScope('ADD_BOOK')}")
    public Book save(@Argument("book") Book book) {
        Author authorFromBook = book.getAuthor();
        Author author = authorRepo.findByFirstNameAndLastName(authorFromBook.getFirstName(), authorFromBook.getLastName());
        book.setAuthor(author);
        return bookRepo.save(book);
    }

    @MutationMapping("deleteBookByIsbn")
    public Book delete(@Argument String isbn) {
        Book book = bookRepo.findByIsbn(isbn).orElse(null);
        if (book != null) {
            bookRepo.delete(book);
        }
        return book;
    }

//    @QueryMapping("allBooks")
//    public Iterable<Book> allBooks() {
//        return bookRepo.findAll();
//    }

//    @QueryMapping("bookByIsbn")
//    public Book bookByIsbn(@Argument("isbn") String isbn) {
//        return bookRepo.findByIsbn(isbn).orElse(null);
//    }
}
