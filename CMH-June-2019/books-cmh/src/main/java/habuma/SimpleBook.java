package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "simple", types = Book.class)
public interface SimpleBook {

	String getTitle();
	
	@Value("#{target.authorFirstName + ' ' + target.authorLastName + ' : ' + T(System).currentTimeMillis()}")
	String getAuthorFullName();
}
