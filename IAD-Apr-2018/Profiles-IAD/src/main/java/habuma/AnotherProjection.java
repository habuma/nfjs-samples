package habuma;

import org.springframework.data.rest.core.config.Projection;

@Projection(types=UserProfile.class, name="another")
public interface AnotherProjection {

	String getUsername();
	String getFirstName();
	
}
