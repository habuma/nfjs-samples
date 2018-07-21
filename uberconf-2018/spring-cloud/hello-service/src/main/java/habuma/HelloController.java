package habuma;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

	private HelloProps props;

	public HelloController(HelloProps props) {
		this.props = props;
	}
	
	@GetMapping
	public String hello(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			log.info("HEADER: " + headerName + " = " + request.getHeader(headerName));
		}
		
		
		log.info("Saying hello");
		return props.getMessage();
	}
	
}
