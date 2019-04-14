package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class BooksController {

  private final BookRepository repo;
  
  @GetMapping("/books")
  public Iterable<Book> allBooks() {
    return repo.findAll(); 
  }
  
  
  @GetMapping("/books/{id}")
  public Book bookById(@PathVariable("id") Book book) {
    return book;
  }
}
