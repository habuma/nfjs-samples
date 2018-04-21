package habuma;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@Slf4j
public class ProfilesController {
	
	private final ProfileRepository repo;
	private final GreetingProps greetingProps;
	
	@GetMapping("/hello")
	public String hello() {
		log.debug("SAYING HELLO");
		return greetingProps.getMessage();
	}
	
	@GetMapping("/{username}")
	public Profile byUsername(@PathVariable("username") String username) {
		return repo.findByUsername(username);
	}
	
	@GetMapping("/byLastName/{ln}")
	public Iterable<Profile> byLN(@PathVariable("ln") String lastName) {
		return repo.findByLastName(lastName);
	}
	
	@GetMapping("/kens")
	public Iterable<Profile> kens() {
		log.info("SAYING HELLO");
		System.out.println("SAYING HELLO");

		repo.doSomethingReallyStupid();
		
		return repo.findAllTheKenPeople();
	}
	
	
	@GetMapping
	public Iterable<Profile> all() {
		return repo.findAll();
	}
	
}
