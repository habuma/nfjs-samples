package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class UserRepoEventListener
	extends AbstractRepositoryEventListener<UserProfile> {

	@Override
	protected void onBeforeDelete(UserProfile entity) {
		
		if (entity.getLastName().equals("Walls")) {
			throw new DontDeleteCraigException();
		}

	}
	
}
