package com.example.prompts;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PromptsApplication {

  public static void main(String[] args) {
    SpringApplication.run(PromptsApplication.class, args);
  }

  private final String systemMessage = """
    Think step by step, but only keep a minimum draft for each thinking step, with 5 words at most. Return the answer at the end of the response after a separator ####.  
    """;

  private final String userMessage = """
      Which is a faster way to get to work?
      Option 1: Take a 1000 minute bus, then a half hour train, and finally a 10 minute bike ride.
      Option 2: Take an 800 minute bus, then an hour train, and finally a 30 minute bike ride.
  """;


  @Bean
  ApplicationRunner go(ChatClient.Builder builder) {
    return args -> {
      var client = builder.build();

      var answer = client.prompt()
          .system(systemMessage)
          .user(userMessage)
          .call()
          .content();

      System.err.println("Answer: " + answer);
    };
  }
}
