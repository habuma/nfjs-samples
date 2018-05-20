package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class RepoEventListener
		extends AbstractRepositoryEventListener<UserProfile> {

	@Override
	protected void onBeforeDelete(UserProfile up) {
		if (up.getLastName().equals("Walls")) {
			throw new DontDeleteCraigException();
		}
	}
	
}
