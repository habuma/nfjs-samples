package habuma.nfjsbooks;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NfjsBooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(NfjsBooksApplication.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(BookRepository repo) {
        return args -> {
            repo.save(new Book(
                    null,
                    "1122334455",
                    "Knitting with Dog Hair",
                    "Kendall Crolius"))
                .subscribe();

            repo.save(new Book(
                            null,
                            "5544332211",
                            "Craft with Cat Hair",
                            "Kaori Tsutaya"))
                    .subscribe();
        };
    }

    @Bean
    ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        return new ObservedAspect(observationRegistry);
    }

}
