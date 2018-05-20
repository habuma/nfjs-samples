package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserProfilesController {

	private final UserProfileRepository repo;
	
	
	
	@GetMapping("/simple/{username}")
	public SimpleUserProfile byUsername(@PathVariable("username") String username) {
		return repo.findSimpleByUsername(username);
	}
	
	
	
	@GetMapping("/qbe")
	public Iterable<UserProfile> qbe() {
		boolean ignoreCase = true;
		
		UserProfile profile = new UserProfile(null, "hfjsdkfhjdsk", "Craig", "wAlLs");
		Example<UserProfile> example = 
				Example.of(profile, 
						ExampleMatcher.matchingAll()
							.withIgnoreCase(ignoreCase)
							.withIgnorePaths("password"));
		
		return repo.findAll(example);
	}
	
}
