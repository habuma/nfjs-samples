package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class MspDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1234567890", "Knitting with Dog Hair"));
			repo.save(new Book("9876543210", "Crafting with Cat Hair"));
		};
	}
	
	
	@Scheduled(fixedRate=1000, initialDelay=5000)
	public void doSomething() {
		System.out.println("I'm doing something");
	}
	
}
