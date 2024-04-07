package habuma.reactivebooksmongoapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReactiveBooksMongoApiApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    public static void main(String[] args) {
        SpringApplication
                .from(ReactiveBooksMongoApiApplication::main)
                .with(MyContainersConfiguration.class)
                .run(args);
    }

}
