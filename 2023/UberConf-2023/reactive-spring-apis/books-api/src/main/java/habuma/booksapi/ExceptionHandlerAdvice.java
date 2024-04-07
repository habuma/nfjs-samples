package habuma.booksapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UnknownBookException.class)
    public ProblemDetail unknownBook(UnknownBookException ex) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(
                        HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setProperty("what", "Crap happened");
        return problemDetail;
    }

}
