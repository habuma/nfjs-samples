package habuma.cmhbooksapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingProps props;

    GreetingController(GreetingProps props) {
        this.props = props;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return props.getMessage();
    }

}
