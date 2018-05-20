package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="simple", types={UserProfile.class})
public interface SimpleUserProfile {

	@Value("#{target.firstName + ' ' + target.lastName}")
	String getFullName();
	
	@Value("#{T(System).currentTimeMillis()}")
	long getTimestamp();
}
