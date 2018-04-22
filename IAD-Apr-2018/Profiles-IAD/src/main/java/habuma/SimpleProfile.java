package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types=UserProfile.class, name="simple")
public interface SimpleProfile {

	@Value("#{target.firstName + ' ' + target.lastName}")
	String getFullname();
	String getSpecialty();
	
}
