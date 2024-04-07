package habuma.booksql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloQlController {

    @QueryMapping("hello")
    public String hello() {
        return "Hello, GraphQL!";
    }

}
