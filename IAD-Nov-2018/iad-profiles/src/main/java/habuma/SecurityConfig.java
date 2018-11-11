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
	private ProfileRepository repo;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/home", true)
				
			.and()		
			
			.logout()
				.logoutSuccessUrl("/login")
			
			.and()
			
			.authorizeRequests()
				.antMatchers("/profiles/**").access("hasRole('ROLE_USER')")
				.antMatchers("/login").permitAll()
				.antMatchers("/**").authenticated();
				
				
				;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(username -> {
				return repo.findByUsername(username);
			});
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
