package com.habuma.booksclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

  @Bean
  HttpServiceProxyFactory httpServiceProxyFactory(RestClient.Builder rcb) {
    RestClientAdapter rcea = RestClientAdapter
        .create(rcb.build());
    return HttpServiceProxyFactory.builder()
        .exchangeAdapter(rcea).build();
  }

  @Bean
  BookClient bookClient(HttpServiceProxyFactory factory) {
    return factory.createClient(BookClient.class);
  }

}
