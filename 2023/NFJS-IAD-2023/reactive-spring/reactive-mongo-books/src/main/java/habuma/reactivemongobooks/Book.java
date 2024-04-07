package habuma.reactivemongobooks;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cappedBooks2")
public record Book(@Id String id, String isbn, String title, String author) {
}
