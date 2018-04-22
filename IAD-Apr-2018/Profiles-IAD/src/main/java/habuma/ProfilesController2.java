package habuma;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class ProfilesController2 {

	private final UserProfileRepository repo;
	
	@GetMapping
	public String profiles(Model model) {
		Iterable<UserProfile> all = repo.findAll();
		model.addAttribute("profiles", all);
		return "profileList";
	}
	
	@GetMapping("/me")
	public String profileByUsername(@AuthenticationPrincipal User user, Model model) {		
		model.addAttribute("profile", repo.findByUsername(user.getUsername()));
		return "profile";
	}
	
}
