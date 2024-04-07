package habuma.cmhbooksapi;

import io.dekorate.kubernetes.annotation.ConfigMapVolume;
import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Mount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@KubernetesApplication(
        configMapVolumes = @ConfigMapVolume(
                configMapName="greeting-config",
                volumeName = "greeting-config-volume",
                defaultMode = 0644),
        mounts = @Mount(
                name="greeting-config-volume",
                path="/etc/config"),
        envVars = @Env(
                name="SPRING_CONFIG_IMPORT",
                value="configtree:/etc/config/"
        )
)
public class CmhBooksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmhBooksApiApplication.class, args);
    }

}
