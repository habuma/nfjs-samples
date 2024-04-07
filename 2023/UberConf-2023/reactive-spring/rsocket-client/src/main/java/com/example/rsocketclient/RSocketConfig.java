package com.example.rsocketclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;

@Configuration
public class RSocketConfig {

    @Bean
    RSocketServiceProxyFactory rSocketServerFactory(RSocketRequester.Builder requestBuilder) {
        RSocketRequester requester = requestBuilder.tcp("localhost", 7001);
        return RSocketServiceProxyFactory.builder(requester).build();
    }

    @Bean
    RSocketClient rSocketClient(RSocketServiceProxyFactory factory) {
        return factory.createClient(RSocketClient.class);
    }
}
