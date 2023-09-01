package habuma.nfjsbooks;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class HelloService {

//    private final ObservationRegistry observationRegistry;

//    public HelloService(ObservationRegistry observationRegistry) {
//        this.observationRegistry = observationRegistry;
//    }

//    public String sayHello() {
//        return Observation
//                .createNotStarted("sayHello", observationRegistry)
//                .observe(this::sayHelloNonObserved);
//    }
//
//    private String sayHelloNonObserved() {
//        try {
//            Thread.sleep((int)(Math.random() * 2000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        if (Math.random() > 0.5) {
//            throw new CrapHappenedException("Oops");
//        }
//
//        return "Hello, world!";
//    }

    @Observed(name="sayHello2")
    public String sayHello() {
        try {
            Thread.sleep((int)(Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (Math.random() > 0.5) {
            throw new CrapHappenedException("Oops");
        }

        return "Hello, world!";
    }

}
