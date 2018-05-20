package habuma;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserProfileController {

	private final UserProfileRepository repo;
	
	@GetMapping("/me")
	public String profilePage(@AuthenticationPrincipal UserDetails user, Model model) {		
		
		model.addAttribute("profile", repo.findByUsername(user.getUsername()));
		
		return "profile";
	}
	
	
}
