package streeteats;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiErrorHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String handleError(Exception e) {
		return "Oops: " + e.getMessage();
	}
	
}
