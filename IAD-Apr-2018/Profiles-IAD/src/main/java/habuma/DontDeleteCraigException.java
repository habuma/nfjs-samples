package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED)
public class DontDeleteCraigException 
	extends UnsupportedOperationException {

	public DontDeleteCraigException() {
		super("Don't delete Craig");
	}
	
}
