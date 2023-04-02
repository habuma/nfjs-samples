package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

	@ExceptionHandler(UnknownBookException.class)
	public ProblemDetail handleUBE(UnknownBookException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
				HttpStatus.NOT_FOUND,
				e.getMessage());
		problemDetail.setProperty("what", "Book ain't there dude");
		return problemDetail;
	}
	
}
