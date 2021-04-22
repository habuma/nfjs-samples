package habuma;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TripProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripProcessorApplication.class, args);
	}

  @Bean
  public Queue itineraries() {
     return new Queue("itineraries", true, false, false);
  }
  
}
