package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserProfilesController {

	private final UserProfileRepository repo;
	
	@GetMapping
	public Iterable<UserProfile> allUser() {
		return repo.findAll();
	}
	
	
	
}
