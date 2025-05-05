package com.example.securebooks2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(AbstractHttpConfigurer::disable)
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults())
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
//                .requestMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/books").hasRole("ADMIN")
                .requestMatchers("/books/**").hasRole("USER"))
        .build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
    var userDetailsService = new InMemoryUserDetailsManager();

//    var habuma = new Reader(
//        "habuma",
//        passwordEncoder.encode("password"),
//        "ROLE_USER", "ROLE_ADMIN");
    var habuma = User.withUsername("habuma")
        .password(passwordEncoder.encode("password"))
        .roles("USER", "ADMIN")
        .build();

    var venkat = User.withUsername("venkat")
        .password(passwordEncoder.encode("password"))
        .roles("USER")
        .build();

    userDetailsService.createUser(venkat);
    userDetailsService.createUser(habuma);

    return userDetailsService;
  }

}
