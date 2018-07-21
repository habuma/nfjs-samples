package hellosayer;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloSayerImpl implements HelloSayer {

	@Override
	@HystrixCommand(fallbackMethod="buggerOff")
	public String sayHelloTo(String name) {
		if ("Craig".equals(name)) {
			throw new IllegalArgumentException();
		}
		
		return "Hello there, " + name + "!!!";
	}
	
	public String buggerOff(String name) {
		return "Bugger off, " + name + "!!!";
	}
	
}
