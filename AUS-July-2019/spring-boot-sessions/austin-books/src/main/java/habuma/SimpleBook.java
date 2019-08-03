package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "simple", types = Book.class)
public interface SimpleBook {

	String getIsbn();
	String getTitle();
	
	@Value("#{target.authorLastName + ', ' + target.authorFirstName}")
	String getAuthor();
	
}
