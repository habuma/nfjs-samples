package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserProfilesController {

	private final UserProfileRepository repo;
	
	private final MeterRegistry mr;
	
	@GetMapping
	public Iterable<UserProfile> allUser() {
		
		mr.counter("HIYA", "A", "B").increment(150);
		
		log.debug("LOGGING STUFF");
		return repo.findAll();
	}
	
	
	
}
