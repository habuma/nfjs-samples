package habuma;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {

	String getIsbn();
	String getTitle();
	String getAuthor();
	
	@Value("#{T(Math).random()}")
	Double getRandomValue();
	
	@Value("#{target.author.toUpperCase()}")
	String getAuthorInFullCase();
	
}
