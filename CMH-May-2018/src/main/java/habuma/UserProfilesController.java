package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/ui/userProfiles")
@RequiredArgsConstructor
public class UserProfilesController {

	private final UserProfileRepository repo;
	
	@GetMapping("/me")
	public String byUsername(@AuthenticationPrincipal UserProfile user, Model model) {
		String username = user.getUsername();	
		model.addAttribute("profile", repo.findByUsername(username));
		return "profile";
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String all(Model model) {
		model.addAttribute("profiles", repo.findAll());
		return "profileList";
	}
	
	@GetMapping("/qbe")
	public @ResponseBody Iterable<UserProfile> qbe() {
		UserProfile up = new UserProfile(
				null, null, "Craig", null);
		Example<UserProfile> example = 
				Example.of(up, 
					ExampleMatcher
						.matchingAny());
		return repo.findAll(example);
	}
	
	@GetMapping("/simple/{username}")
	@ResponseBody
	public SimpleUserProfile simple(@PathVariable("username") String username) {
		return repo.findSimpleUserProfileByUsername(username);
	}
	
	@GetMapping("/audit/{username}")
	@ResponseBody
	public String audit(@PathVariable("username") String username) {
		return username + ": YOU'RE BEING AUDITED!!!";
	}
	
}
