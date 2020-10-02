package habuma;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Book {

	private String id;
	private final String isbn;
	private final String title;
	private final String author;
	
}
