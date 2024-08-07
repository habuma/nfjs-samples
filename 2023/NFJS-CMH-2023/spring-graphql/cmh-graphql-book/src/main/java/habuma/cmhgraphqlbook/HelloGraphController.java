package habuma.cmhgraphqlbook;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloGraphController {

    @QueryMapping("hello")
    public String hello() {
        return "Hello, GraphQL world!";
    }

    @QueryMapping("goodbye")
    public String goodbye() {
        return "See ya later!";
    }
}
