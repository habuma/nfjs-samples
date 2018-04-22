package habuma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig 
		extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserProfileRepository userRepo;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		// @formatter:off
		
		http
			.formLogin()
				.loginPage("/login")
		
			.and()
				
			.authorizeRequests()
				.antMatchers("/users/**").authenticated()
				.antMatchers("/login").permitAll()
				.antMatchers("/**").permitAll();

		// @formatter:on

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(username -> {
				UserProfile profile = userRepo.findByUsername(username);
				User userDetails = new User(
						profile.getUsername(), 
						profile.getPassword(), 
						profile.getAuthorities());
				return userDetails;
			});
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
