package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/userProfiles")
@RequiredArgsConstructor
public class UserProfilesController {

	private final UserProfileRepository repo;
	
	@GetMapping("/{username}")
	public String byUsername(
			@PathVariable("username") String username,
			Model model) {
		model.addAttribute("profile", repo.findByUsername(username));
		return "profile";
	}
	
	@GetMapping
	public String all(Model model) {
		model.addAttribute("profiles", repo.findAll());
		return "profileList";
	}
	
}
