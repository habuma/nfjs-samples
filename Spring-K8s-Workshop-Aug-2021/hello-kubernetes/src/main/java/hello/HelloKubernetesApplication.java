package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloKubernetesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloKubernetesApplication.class, args);
	}

}
