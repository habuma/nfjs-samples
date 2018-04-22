package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfilesController2 {

	private final UserProfileRepository repo;
	
	@GetMapping("/x")
	public String profiles(Model model) {
		Iterable<UserProfile> all = repo.findAll();
		model.addAttribute("profiles", all);
		return "profileList";
	}
	
}
