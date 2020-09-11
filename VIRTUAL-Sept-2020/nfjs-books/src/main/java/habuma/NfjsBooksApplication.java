package habuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NfjsBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfjsBooksApplication.class, args);
	}

}
