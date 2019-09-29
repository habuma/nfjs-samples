package habuma;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
	
	private final BooksRepository bookRepo;

	@GetMapping
	public Iterable<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> bookById(@PathVariable("id") Long id){
		return bookRepo.findById(id);
	}
	
	@PostMapping
	public Book saveABook(@RequestBody Book book) {
		return bookRepo.save(book);
	}
	
}
