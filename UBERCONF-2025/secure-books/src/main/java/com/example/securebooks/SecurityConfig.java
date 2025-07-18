package com.example.securebooks;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .httpBasic(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authReq -> {
          authReq.requestMatchers(HttpMethod.POST, "/books").authenticated();
          authReq.requestMatchers(HttpMethod.DELETE, "/books/**").authenticated();
          authReq.requestMatchers(HttpMethod.GET, "/books").authenticated();
        })
        ;


    return http.build();
  }


  @Bean
  UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
    var userDetailsService = new InMemoryUserDetailsManager();
    var habuma = User.withUsername("habuma")
        .password(passwordEncoder.encode("password"))
        .roles("USER", "ADMIN").build();
    var izzy = User.withUsername("izzy")
        .password(passwordEncoder.encode("password"))
        .roles("USER").build();

    userDetailsService.createUser(habuma);
    userDetailsService.createUser(izzy);
    return userDetailsService;
  }

  @Bean
  PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }

}
