package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrapHappenedExceptionAdvice {

	@ExceptionHandler(CrapHappenedException.class)
	@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
	public StandardError handleCHE(CrapHappenedException e) {
		return new StandardError(123L, e.getMessage());
	}
}
