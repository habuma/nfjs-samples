package habuma.cmhhelloclient;

import io.dekorate.kubernetes.annotation.Ingress;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@KubernetesApplication(
		ingress = @Ingress(expose = true)
)
@SpringBootApplication
public class CmhHelloClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmhHelloClientApplication.class, args);
	}

}
