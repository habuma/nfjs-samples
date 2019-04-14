package habuma.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

	private final BooksRepository repo;
	
	@GetMapping
	public Iterable<Book> books() {
		return repo.findAll();
	}
	
}
