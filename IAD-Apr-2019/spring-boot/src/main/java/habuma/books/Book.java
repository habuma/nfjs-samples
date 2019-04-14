package habuma.books;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {
	
	public Book(Long id, String isbn, String title, String author) { 
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	private Long id;
	private final String isbn;
	private final String title;
	private final String author;

}
