package com.example.uberbooksclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestConfig {

  @Bean
  HttpServiceProxyFactory httpServiceProxyFactory(RestClient.Builder builder) {
    RestClient restClient = builder.build();
    RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);
    return HttpServiceProxyFactory.builder()
        .exchangeAdapter(restClientAdapter)
        .build();
  }

  @Bean
  BookClient bookClient(HttpServiceProxyFactory httpServiceProxyFactory) {
    return httpServiceProxyFactory.createClient(BookClient.class);
  }


}
