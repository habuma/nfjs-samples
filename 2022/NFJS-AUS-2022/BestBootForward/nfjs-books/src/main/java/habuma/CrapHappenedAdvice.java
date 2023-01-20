package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrapHappenedAdvice {

//	@ExceptionHandler(CrapHappenedException.class)
//	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
//	public StandardError handleCrapHappened(CrapHappenedException e) {
//		return new StandardError(1234, e.getMessage());
//	}
	
	@ExceptionHandler(CrapHappenedException.class)
	public ProblemDetail handleCrapHappened(CrapHappenedException e) {
		ProblemDetail problemDetail =
				ProblemDetail.forStatusAndDetail(HttpStatus.I_AM_A_TEAPOT, e.getMessage());
		problemDetail.setProperty("where", "Austin");
		return problemDetail;
	}

	
}
