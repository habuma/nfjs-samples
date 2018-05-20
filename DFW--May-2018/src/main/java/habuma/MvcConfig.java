package habuma;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addRedirectViewController("/", "/users/me");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("loginpage");
		registry.addViewController("/secret").setViewName("supersecret");
	}
	
}
