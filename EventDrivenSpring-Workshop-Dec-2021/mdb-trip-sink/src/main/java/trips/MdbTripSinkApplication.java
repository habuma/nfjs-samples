package trips;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MdbTripSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdbTripSinkApplication.class, args);
	}

	@Bean
	public Queue trips() {
		return new Queue("trips", true, false, false);
	}
}
