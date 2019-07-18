package habuma;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.Info.Builder;

@Component
public class RandomInfoContributor 
	implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		double random = Math.random();
		
		Book book = new Book("1234567890", "Knitting with Dog Hair", "Kendall", "Crolius");
		
		builder
			.withDetail("random", random)
			.withDetail("dog-hair-book", book);
	}
	
}
