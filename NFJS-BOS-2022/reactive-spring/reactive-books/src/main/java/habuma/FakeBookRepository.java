package habuma;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FakeBookRepository implements BookRepository {

	@Override
	public Flux<Book> findAll() {
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book(1L, "1122334455", 
						"Knitting with Dog Hair", "Kendall Crolius"));
		books.add(new Book(2L, "5544332211", 
				"Crafting with Cat Hair", "Kaori Tsutaya"));
		return Flux.fromIterable(books);
	}

	@Override
	public Mono<Book> findByIsbn(String isbn) {
		return Mono.just(
				new Book(1L, "1122334455", 
						"Knitting with Dog Hair", "Kendall Crolius"));
	}

}
