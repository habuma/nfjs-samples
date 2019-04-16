package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DontDeleteEventListener 
	extends AbstractRepositoryEventListener<Book> {

	@Override
	protected void onBeforeDelete(Book book) {
		log.info("ABOUT TO DELETE:  " + book);
		if (book.getAuthor().getLastName().equals("Walls")) {
			throw new DontDeleteCraigsBooksException();
		}
	}
	
	@Override
	protected void onAfterDelete(Book book) {
		log.info("JUST DELETED:  " + book);
	}
	
	
}
