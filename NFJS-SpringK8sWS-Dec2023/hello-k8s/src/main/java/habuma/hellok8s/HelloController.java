package habuma.hellok8s;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final GreetingConfig props;

    public HelloController(GreetingConfig props) {
        this.props = props;
    }

    @GetMapping("/hello")
    public String hello() {
        return props.getMessage();
    }

}
