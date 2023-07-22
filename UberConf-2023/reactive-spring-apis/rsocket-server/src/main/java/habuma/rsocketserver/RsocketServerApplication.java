package habuma.rsocketserver;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RsocketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsocketServerApplication.class, args);
    }
}
