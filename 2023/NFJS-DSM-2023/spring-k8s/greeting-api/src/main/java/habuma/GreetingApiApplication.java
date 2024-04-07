package habuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.dekorate.kubernetes.annotation.ConfigMapVolume;
import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Mount;

@SpringBootApplication
/*
  Create a ConfigMap:

  kubectl create configmap greeting-config \
      --from-literal="greeting.hello=Hello K8s" \
      --from-literal="greeting.goodbye=See ya later"
 */
@KubernetesApplication(
    configMapVolumes = @ConfigMapVolume(
        configMapName = "greeting-config", 
        volumeName = "greeting-config-volume", 
        defaultMode = 0644), // <- Octal literal for filesystem permissions
    mounts = @Mount(
        name = "greeting-config-volume", 
        path = "/etc/config"),
    envVars = @Env(
        name = "SPRING_CONFIG_IMPORT", 
        value = "configtree:/etc/config/"))
public class GreetingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingApiApplication.class, args);
	}

}
