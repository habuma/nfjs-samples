package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;

@SpringBootApplication
public class RsocketClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsocketClientApplication.class, args);
	}


	@Bean
	public CommandLineRunner clr(RSocketRequester.Builder requesterBuilder) {
		return args -> {
			RSocketRequester requester = requesterBuilder
					.connectTcp("localhost", 7000)
					.block();
			
			requester
				.route("book")
				.data(new Book("1234567890", "Hi there", "Bob"))
				.retrieveFlux(String.class)
				.subscribe(response -> {
					System.out.println(response);
				});
		};
	}

}
