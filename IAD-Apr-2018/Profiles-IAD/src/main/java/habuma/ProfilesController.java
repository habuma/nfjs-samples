package habuma;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class ProfilesController {
	
	private final UserProfileRepository repo;
	private final GreetingProps greetingProps;
	
	@GetMapping("/hello")
	public String hello() {
		log.debug("SAYING HELLO");
		return greetingProps.getMessage();
	}
	
	@GetMapping("/proj")
	public SimpleProfile proj() {
		return repo.findSimpleProfileByUsername("ken");
	}
	
}
