package habuma.libraryapi;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.ObservationTextPublisher;
import io.micrometer.observation.aop.ObservedAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
//import org.springframework.web.client.RestClient;

@SpringBootApplication
public class LibraryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApiApplication.class, args);
    }

    @Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }

    @Bean
    ApplicationRunner go(BookApiClient client) {
        return args -> {
            String isbn = "1122334455";
            Book book = client.getBookByIsbn(isbn);
            System.out.println("Got book: " + book);
        };
    }

    private static final Logger log = LoggerFactory.getLogger(LibraryApiApplication.class);

    @Bean
    ObservationHandler<Observation.Context> obsTextPublisher() {
        return new ObservationTextPublisher(log::info);
    }

    @Bean
    ObservedAspect observedAspect(ObservationRegistry registry) {
        return new ObservedAspect(registry);
    }

//    @Bean
    // commented out because we're not going to use it any further
//    ApplicationRunner go() {
//        return args -> {
//
//            RestClient restClient =
//                    RestClient.create("http://localhost:8080");
//
//            String isbn = "1122334455";
//
//            Book book = restClient
//                    .get()
//                    .uri("/books/isbn/{isbn}", isbn)
//                    .retrieve()
//                    .body(Book.class);
//
//            System.out.println("Got book: " + book);
//        };
//    }

}
