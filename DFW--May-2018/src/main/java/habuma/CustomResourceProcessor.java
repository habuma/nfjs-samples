package habuma;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomResourceProcessor implements ResourceProcessor<Resource<UserProfile>> {

	private final EntityLinks entityLinks;
	
	@Override
	public Resource<UserProfile> process(Resource<UserProfile> resource) {
		resource.add(
				entityLinks.linkForSingleResource(UserProfile.class, resource.getContent().getUsername())
				.slash("SOMECRAZYLINK")
				.withRel("CRAZY")
				);
		return resource;
	}
	
}
