package habuma;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {

	String getIsbn();
	String getTitle();
//	String getAuthor();
	
	@Value("#{target.author.split(' ')[1]}")
	String getAuthorLastName(); 
	
	@Value("#{target.author.split(' ')[0]}")
	String getAuthorFirstName();
	
	@Value("#{T(System).currentTimeMillis()}")
	Long getTimestamp();
	
}
