package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED)
public class DontDeleteCraigException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
