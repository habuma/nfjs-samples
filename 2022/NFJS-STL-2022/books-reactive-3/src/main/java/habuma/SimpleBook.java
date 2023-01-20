package habuma;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {

	String getIsbn();
	String getTitle();
	String getAuthor();
	
	@Value("#{target.author.toUpperCase()}")
	String getAuthorAllCaps();
	
}
