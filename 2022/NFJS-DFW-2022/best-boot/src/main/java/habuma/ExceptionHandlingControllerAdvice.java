package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlingControllerAdvice {

	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
	@ExceptionHandler(FlakyException.class) 
	public StandardizedError handle(FlakyException e) {
		return new StandardizedError(123, e.getMessage());
	}
	
}
