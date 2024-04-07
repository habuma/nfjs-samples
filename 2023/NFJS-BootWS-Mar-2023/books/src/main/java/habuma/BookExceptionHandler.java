package habuma;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

  @ExceptionHandler(BookNotFoundException.class)
  public ProblemDetail handlerBNFE(BookNotFoundException e) {
    ProblemDetail problemDetail = 
        ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND, e.getMessage());
    problemDetail.setProperty("extra info", "I don't know that book.");
    return problemDetail;
  }
  
}
