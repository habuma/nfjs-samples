package habuma;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScsTripSinkApplication {
  private static final Logger log = LoggerFactory.getLogger(ScsTripSinkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScsTripSinkApplication.class, args);
	}

	@Bean
	public Consumer<Itinerary> scheduleItinerary() {
	  return itinerary -> {
	    log.info("SCHEDULING ITINERARY:  " + itinerary);
	  };
	}
}
