package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "simple", types = Book.class)
public interface SimplePublication {

	String getTitle();
	
	@Value("#{target.author.firstName + ' ' + target.author.lastName}")
	String getAuthor();
	
	@Value("#{T(System).currentTimeMillis()}")
	Long getTimestamp();
	
}
