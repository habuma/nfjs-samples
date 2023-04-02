package habuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.dekorate.kubernetes.annotation.ConfigMapVolume;
import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.Ingress;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Mount;

@SpringBootApplication
@KubernetesApplication(
		configMapVolumes= @ConfigMapVolume(
				configMapName="greeting-config",
				volumeName="greeting-config-volume",
				defaultMode=0644),
		mounts = @Mount(
				name="greeting-config-volume",
				path="/etc/config"),
		envVars=@Env(
				name="SPRING_CONFIG_IMPORT",
				value="configtree:/etc/config/"),
		ingress=@Ingress(expose=true)
		)
public class GreetingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApiApplication.class, args);
	}

}
