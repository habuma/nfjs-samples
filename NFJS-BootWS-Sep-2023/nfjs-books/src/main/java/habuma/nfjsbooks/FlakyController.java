package habuma.nfjsbooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlakyController {

    @GetMapping("/flaky")
    public String flaky() {
        if (Math.random() < 0.5) {
            throw new CrapHappenedException("Oops");
        }
        return "OK";
    }

}
