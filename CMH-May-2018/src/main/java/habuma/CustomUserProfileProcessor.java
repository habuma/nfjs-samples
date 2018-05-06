package habuma;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserProfileProcessor 
	implements ResourceProcessor<Resource<UserProfile>> {
	
	private final @NonNull EntityLinks entityLinks;
	
	@Override
	public Resource<UserProfile> process(
			     Resource<UserProfile> resource) {
		
		resource.add(entityLinks.linkForSingleResource(
				UserProfile.class, resource.getContent().getUsername())
				.slash("/bogusLink")
				.withRel("bogus")
				);
		
		resource.add(new Link("http://localhost:8080/ui/userProfiles/audit/" + 
					resource.getContent().getUsername(), "audit"));
		
		return resource;
	}

}
