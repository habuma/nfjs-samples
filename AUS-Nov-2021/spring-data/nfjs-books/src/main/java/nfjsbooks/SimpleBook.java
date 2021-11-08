package nfjsbooks;

import org.springframework.beans.factory.annotation.Value;

public interface SimpleBook {

	String getTitle();
	String getAuthor();
	
	@Value("#{T(System).currentTimeMillis()}")
	long getTimestamp();
	
}
