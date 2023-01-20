package habuma;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlakyController {

	@GetMapping("/flaky")
	public String flaky() {
		double value = Math.random();
		if (value < 0.5) {
			throw new CrapHappenedException("The value was too low: " + value);
		}
		return "It works!";
	}
	
}
