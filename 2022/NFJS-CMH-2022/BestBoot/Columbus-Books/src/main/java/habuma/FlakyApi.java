package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlakyApi {

	@GetMapping("/flaky")
	public String flaky() {
		double random = Math.random();
		if (random > 0.5) {
			return "SUCCESS!";
		}
		
		throw new CrapHappenedException("The number was too low: " +random);
	}
	
}
