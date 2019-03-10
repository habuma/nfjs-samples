package habuma;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MyInfoContributor 
	implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder
			.withDetail("address", "123 NorthStreet")
			.withDetail("random", Math.random())
			.build();
	}
	
}
