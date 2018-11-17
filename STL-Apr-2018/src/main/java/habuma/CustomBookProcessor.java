package habuma;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomBookProcessor 
	implements ResourceProcessor<Resource<Book>> {

	private final @NonNull EntityLinks entityLinks;
	
	@Override
	public Resource<Book> process(Resource<Book> resource) {
		Book book = resource.getContent();
		
		if(book.getTitle().contains("Camel")) {
			resource.add(
					entityLinks
					  .linkForSingleResource(Book.class, book.getIsbn())
					  .slash("BUY")
					  .slash("NOW")
					  .withRel("BUY_THIS_BOOK")
					);
		}
		
		return resource;
	}
	
}
