package habuma;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="uberconf", enableByDefault = true)
public class UberConfEndpoint {

	private Book book = new Book("1234567890", "Crafting with Cat Hair", "Kaori", "Tsutaya");;

	@ReadOperation
	public Book getABook() {
		return book;
	}
	
	@WriteOperation
	public Book setBook(Book book) {
		this.book = book;
		return book;
	}
	
}
