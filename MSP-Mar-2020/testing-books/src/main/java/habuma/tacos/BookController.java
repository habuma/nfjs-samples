package habuma.tacos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

	private final BookRepository bookRepo;
	
	@GetMapping
	public Iterable<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book saveABook(@RequestBody Book book) {
		return bookRepo.save(book);
	}
	
	@GetMapping(params = "author")
	public Iterable<Book> byAuthor(@RequestParam("author") String author) {
		return bookRepo.findByAuthor(author);
	}
	
}
