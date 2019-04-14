package habuma.books;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DemoInfoContributor 
	implements InfoContributor {

	private final GreetingProps props;
	
	@Override
	public void contribute(Builder builder) {
		builder
			.withDetail("time", System.currentTimeMillis())
			.withDetail("greeting-props", props);
	}

}
