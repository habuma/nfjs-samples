package habuma;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberInfoContributor 
	implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("number", Math.random()).build();
	}
	
}
