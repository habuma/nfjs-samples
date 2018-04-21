package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfilesController {

	private final ProfileRepository repo;
	private final GreetingProps greetingProps;
	
	@GetMapping("/hello")
	public String hello() {
		return greetingProps.getMessage();
	}
	
	@GetMapping
	public Iterable<Profile> all() {
		return repo.findAll();
	}
	
}
