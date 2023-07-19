package habuma.rsocketclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.service.RSocketServiceProxyFactory;

@Configuration
public class RSocketConfig {

    @Bean
    RSocketServiceProxyFactory rsocketServiceProxyFactory(
            RSocketRequester.Builder builder) {
        RSocketRequester requester = builder
                .tcp("localhost", 7001);
        return RSocketServiceProxyFactory
                .builder(requester)
                .build();
    }

    @Bean
    public HelloClient helloClient(RSocketServiceProxyFactory factory) {
        return factory.createClient(HelloClient.class);
    }

}
