package habuma.hellok8s;

import io.dekorate.kubernetes.annotation.ConfigMapVolume;
import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Mount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@KubernetesApplication(
        configMapVolumes = @ConfigMapVolume(
                configMapName = "greeting-props",
                volumeName = "gpvolume",
                defaultMode = 0644
        ),
        mounts = @Mount(
                name="gpvolume",
                path = "/etc/config"
        ),
        envVars = @Env(
                name = "SPRING_CONFIG_IMPORT",
                value = "configtree:/etc/config/"
        )
)
public class HelloK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloK8sApplication.class, args);
    }

}
