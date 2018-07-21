package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class RepoEventListener 
	extends AbstractRepositoryEventListener<Book> {

	@Override
	protected void onBeforeDelete(Book book) {
		if (book.getAuthorFirstName().equals("Craig") &&
				book.getAuthorLastName().equals("Walls")) {
			System.out.println("********************* ABOUT TO DELETE");
			
			throw new DontDeleteCraigsBooksException();
			
		}
	}
	
}
