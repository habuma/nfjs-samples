package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FlakyExceptionHandler {

	@ExceptionHandler(FlakyException.class)
	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
	public StandardError handleFlaky(FlakyException e) {
		return new StandardError(123, e.getMessage(), "Pick higher numbers");
	}
	
}
