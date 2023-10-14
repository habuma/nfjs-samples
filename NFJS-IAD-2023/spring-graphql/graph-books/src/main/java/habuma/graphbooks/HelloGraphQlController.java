package habuma.graphbooks;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloGraphQlController {

    @QueryMapping("hello")
    public String hello() {
        return "Hello, world!";
    }

}
