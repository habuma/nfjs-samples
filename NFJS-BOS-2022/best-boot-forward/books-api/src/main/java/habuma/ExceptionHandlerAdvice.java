package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(CrapHappenedException.class)
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	public StandardError handleCHE(CrapHappenedException e) {
		return new StandardError(999, e.getMessage());
	}
	
}
