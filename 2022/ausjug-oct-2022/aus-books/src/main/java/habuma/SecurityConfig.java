package habuma;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain sfc(HttpSecurity http) throws Exception {
    return
         http
           .httpBasic()
           .and()
           .csrf()
             .disable() // generally a bad idea, but this allows POSTS (specifically for the /graphql requests)
           .authorizeRequests()
             .antMatchers("/books/**").hasRole("READER")
             .anyRequest().permitAll() // to allow "hello" and "graphql"
            .and()
            .build();
  }

  @Bean
  public UserDetailsService uds(PasswordEncoder encoder) {
    return new InMemoryUserDetailsManager(
        new User("habuma", encoder.encode("password"), 
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_READER"))),
    new User("thanos", encoder.encode("password"), 
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_TITAN"))));
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
