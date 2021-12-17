package trips;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MdbTripProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdbTripProcessorApplication.class, args);
	}
	
	@Bean
	public Queue itineraries() {
		return new Queue("itineraries", true, false, false);
	}

	@Bean
	public Queue trips() {
		return new Queue("trips", true, false, false);
	}
}
