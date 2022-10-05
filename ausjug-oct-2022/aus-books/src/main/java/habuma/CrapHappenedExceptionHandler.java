package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrapHappenedExceptionHandler {

  @ExceptionHandler(CrapHappenedException.class)
  @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
  public StandardError handle(CrapHappenedException e) {
    return new StandardError(999, "Crap happened: " + e.getMessage());
  }
  
}
