package habuma;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Book {

	@Id
	private String id;
	
	private final String isbn;
	private final String title;
	private final String author;
	
}
