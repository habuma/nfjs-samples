package habuma.graphqlbooks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloGraphQlController {

    @QueryMapping("hello")
    public String hello() {
        return "Hello, GraphQL!";
    }

}
