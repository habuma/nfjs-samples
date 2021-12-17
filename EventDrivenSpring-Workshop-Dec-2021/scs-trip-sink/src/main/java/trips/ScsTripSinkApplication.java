package trips;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScsTripSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsTripSinkApplication.class, args);
	}
	
	@Bean("scheduleItinerary")
	public Consumer<Itinerary> schedule() {
		return itinerary -> {
			System.out.println("SCHEDULING A TRIP TO " + itinerary.getDestination());
		};
	}

}
