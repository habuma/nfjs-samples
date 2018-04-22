package habuma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomUserProfileProcessor
		implements ResourceProcessor<Resource<UserProfile>> {
	
	@Autowired
	EntityLinks entityLinks;
	
	@Override
	public Resource<UserProfile> process(Resource<UserProfile> resource) {
		UserProfile userProfile = resource.getContent();
		
		Link awesome = entityLinks.linkForSingleResource(UserProfile.class, userProfile.getUsername())
			.slash("doSomethingAwesome")
			.slash("rightNow")
			.slash("please")
			.withRel("AWESOME");
			
		resource.add(awesome);
		
		return resource;
	}

}
