package trips;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MdbTripSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdbTripSourceApplication.class, args);
	}

	@Bean
	public Queue itineraries() {
		return new Queue("itineraries", true, false, false);
	}
}
