package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BooksController {

  private final BookRepository repo;
  
  @GetMapping
  public Iterable<Book> allBooks() {
    return repo.findAll(); 
  }
  
  @GetMapping("/{id}")
  public Book byId(@PathVariable("id") Book book) {
	    return book;
  }

  
  @GetMapping("/isbn/{isbn}")
  public SimpleBook byIsbn(@PathVariable("isbn") String isbn) {
    return repo.findSimpleByIsbn(isbn); 
  }
  
  @PostMapping
  public Book saveABook(@RequestBody Book book) {
	  return repo.save(book);
  }
  
  
}
