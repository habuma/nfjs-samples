package habuma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http
				.authorizeExchange()
				.pathMatchers(HttpMethod.POST, "/books")
				.authenticated().anyExchange()
				.permitAll()
				.and().httpBasic()
				.and().csrf().disable() // WARNING!
				.build();
	}
	
	@Bean
	public MapReactiveUserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails user = User
				.withUsername("habuma")
				.password(encoder.encode("password"))
				.authorities("ROLE_USER")
				.build();

		return new MapReactiveUserDetailsService(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

