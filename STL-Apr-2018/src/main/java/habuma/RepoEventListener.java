package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class RepoEventListener
	extends AbstractRepositoryEventListener<Book> {
	
	@Override
	protected void onBeforeDelete(Book entity) {
		System.out.println("ABOUT TO DELETE:  " + entity.getTitle());
		if (entity.getTitle().toLowerCase().contains("camel")) {
			throw new ILikeCamelsException();
		}
	}

}
