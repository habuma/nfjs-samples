package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class RepoEventListener 
		extends AbstractRepositoryEventListener<UserProfile> {

	@Override
	protected void onBeforeDelete(UserProfile entity) {
		System.out.println("ABOUT TO DELETE: " + entity);
		if (entity.getUsername().equals("habuma")) {
			throw new DontDeleteCraigException();
		}
	}
	
}
