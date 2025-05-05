package com.example.booksclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

  @Bean
  HttpServiceProxyFactory httpServiceProxyFactory() {
    return HttpServiceProxyFactory
        .builderFor(RestClientAdapter.create(RestClient.create()))
        .build();
  }

  @Bean
  BookClient tacoCloudClient(HttpServiceProxyFactory factory) {
    return factory.createClient(BookClient.class);
  }

}
