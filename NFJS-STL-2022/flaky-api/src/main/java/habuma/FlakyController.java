package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flaky")
public class FlakyController {

	@GetMapping
	public String flaky() {
		double random = Math.random();
		if (random > 0.5) {
			return "It worked!";
		}
		
		throw new UglyException("The value was too low!");
	}
	
	@ExceptionHandler(UglyException.class)
	@ResponseStatus(code=HttpStatus.I_AM_A_TEAPOT)
	public StandardError handleUglyException(UglyException e) {
		StandardError standardError = new StandardError();
		standardError.setReason(e.getMessage());
		standardError.setCode(123);
		return standardError;
	}
	
}
