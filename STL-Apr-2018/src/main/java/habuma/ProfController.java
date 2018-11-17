package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prof")
@RequiredArgsConstructor
public class ProfController {
	
	private final ProfileRepository repo;

	@GetMapping
	public Iterable<Profile> byExample() {
		
		Profile exampleProfile = new Profile("NATE", null, "nate Schutta", false);
		
		Example<Profile> example = 
				Example.of(exampleProfile,
						ExampleMatcher.matching()
						  .withIgnoreCase("username", "fullName"));
		
		
		return repo.findAll(example);
		
	}
	
}
