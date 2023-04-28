package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksController {

  private BookRepository bookRepo;
  private AuthorRepository authorRepo;
  
  public BooksController(BookRepository bookRepo, AuthorRepository authorRepo) {
    this.bookRepo = bookRepo;
    this.authorRepo = authorRepo;
  }
  
//  @QueryMapping(name="allBooks")
//  public Iterable<Book> allBooks() {
//    return bookRepo.findAll();
//  }
//  
//  @QueryMapping(name="byIsbn")
//  public Book byIsbn(@Argument("isbn") String isbn) {
  // or:
  //   return bookRepo.findOne(Example.of(new Book("1122334455", null, null))
//    return bookRepo.findByIsbn(isbn);
//  }
//  
  @MutationMapping(name="delete")
  public Book delete(@Argument("isbn") String isbn) {
    System.out.println("DELETING: " + isbn);
    Book bookToDelete = bookRepo.findByIsbn(isbn);
    bookRepo.delete(bookToDelete);
    return bookToDelete;
  }
  
  @MutationMapping(name="addAuthor")
  public Author addAuthor(@Argument("author") Author author) {
    return authorRepo.save(author);
  }
  
  @MutationMapping(name="addAuthor2")
  public Author addAuthor(
      @Argument("firstName") String firstName,
      @Argument("lastName") String lastName) {
    return authorRepo.save(new Author(firstName, lastName));
  }
  
//  @MutationMapping(name="addBook")
//  public Book addBook(@Argument("book") Book book) {
//    Author savedAuthor = authorRepo.save(book.getAuthor());
//    book.setAuthor(savedAuthor);
//    return bookRepo.save(book);
//  }
  
  @MutationMapping(name="addBook")
  public Book addBook(@Argument("book") BookIn book) {
    Author savedAuthor = authorRepo.findById(book.getAuthorId()).get();
    
    Book bookToSave = new Book(book.getIsbn(), book.getTitle(), savedAuthor);
    return bookRepo.save(bookToSave);
  }
  
}





















