package habuma;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelloServiceImpl implements HelloService {

	private final RestTemplate rest;
	
	@Override
	@HystrixCommand(fallbackMethod="getDefaultGreeting")
	public String getGreeting() {
		log.info("Requesting greeting from greeting-service");
		return rest.getForObject("http://greeting-service/greeting", String.class);
	}

	@Override
	@HystrixCommand(fallbackMethod="getDefaultWho")
	public String getWho() {
		log.info("Requesting who from who-service");
		return rest.getForObject("http://who-service/who", String.class);
	}
	
	public String getDefaultGreeting() {
		return "Howdy";
	}
	
	public String getDefaultWho() {
		return "Denver";
	}

}
