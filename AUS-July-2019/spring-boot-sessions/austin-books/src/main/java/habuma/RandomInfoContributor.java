package habuma;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.Info.Builder;

@Component
public class RandomInfoContributor 
	implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		builder
			.withDetail("random-number", Math.random())
			.withDetail("some-book", new Book("1029384756", "Crafting with Cat Hair", "Kaori", "Tsutaya"));
	}
	
}
