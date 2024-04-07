package habuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import io.dekorate.kubernetes.annotation.Ingress;
import io.dekorate.kubernetes.annotation.KubernetesApplication;

@SpringBootApplication()
@KubernetesApplication(
    ingress = @Ingress(expose = true)
            
    )
public class GreetingWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingWebApplication.class, args);
	}

	@Bean
  WebClient k8sWebClient() {
    return WebClient.create("http://greeting-api");
  }
}
