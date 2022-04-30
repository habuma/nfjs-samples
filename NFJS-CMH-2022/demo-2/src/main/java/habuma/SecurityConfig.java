package habuma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityChain(HttpSecurity http) throws Exception {
		return http
				.httpBasic()
				.and()
				.authorizeRequests()
					.requestMatchers(EndpointRequest.to("env", "beans"))
						.hasAnyRole("USER")
					.requestMatchers(EndpointRequest.toAnyEndpoint())
						.permitAll()
				.and()
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		return username -> {
			if (username.equals("habuma")) {
				List<GrantedAuthority> auths = new ArrayList<>();
				auths.add(new SimpleGrantedAuthority("ROLE_USER"));
				return new User(username, encoder.encode("password"), auths);
			}
			throw new UsernameNotFoundException("User " + username + " not found.");
		};
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
