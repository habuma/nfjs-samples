package habuma.nfjsbooks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestControllerAdvice
public class ProblemHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CrapHappenedException.class)
    public Mono<ProblemDetail> handle(CrapHappenedException ex) {
        ProblemDetail problem = ProblemDetail
                .forStatus(HttpStatus.I_AM_A_TEAPOT);
        problem.setDetail(ex.getMessage());
        problem.setType(URI.create("https://example.org/crap-happened"));
        problem.setProperty("crap", "happened");
        problem.setProperty("xyz", "123");
        return Mono.just(problem);
    }

}
