package com.example.springaioptions;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiOptionsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringAiOptionsApplication.class, args);
  }

//  @Bean
  ApplicationRunner go(ChatClient.Builder chatClientBuilder) {
    return args -> {
      var chatClient = chatClientBuilder.build();

      var response = chatClient.prompt()
          .user("What are the top songs on the Billboard Top 100 for 1985?")
          .call()
          .content();

      System.err.println("Response: " + response);
    };
  }

}
