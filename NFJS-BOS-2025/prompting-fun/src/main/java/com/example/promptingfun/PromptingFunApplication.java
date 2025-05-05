package com.example.promptingfun;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class PromptingFunApplication {

  @Value("classpath:/systemPrompt.st")
  Resource systemPrompt;

  public static void main(String[] args) {
    SpringApplication.run(PromptingFunApplication.class, args);
  }

  @Bean
  ApplicationRunner go(ChatClient.Builder clientBuilder) {
    return args -> {
      ChatClient client = clientBuilder.build();
      var answer = client.prompt()
          .user("Pass me the salt")
          .system(systemPrompt)
          .call()
          .content();

      System.err.println(answer);
    };
  }

}
