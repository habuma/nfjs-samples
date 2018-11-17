package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.METHOD_NOT_ALLOWED)
public class ILikeCamelsException extends RuntimeException {

}
