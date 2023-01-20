package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

	@ExceptionHandler(NotAFruitException.class)
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	public StandardizedError handle(NotAFruitException e) {
		return new StandardizedError(123, e.getMessage());
	}
	
}
