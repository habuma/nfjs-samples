package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public Mono<String> hello() {
		//...
		return Mono.just("Hello Reactive World!!!!!!!!!")
				.map(text -> text.toUpperCase());
	}
	
	@PostMapping("/echobook")
	public Mono<Book> addABook(@RequestBody Mono<Book> book) {
		return book
				.map(book2 -> new Book(book2.getIsbn(), 
						book2.getTitle(), 
						book2.getAuthor().toUpperCase()));
	}
	
}
