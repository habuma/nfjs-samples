package com.example.ragfun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

@SpringBootApplication
public class RagFunApplication {

  public static void main(String[] args) {
    SpringApplication.run(RagFunApplication.class, args);
  }

  @Bean
  RestClientCustomizer logbookCustomizer(LogbookClientHttpRequestInterceptor interceptor) {
    return restClient -> restClient.requestInterceptor(interceptor);
  }

}
