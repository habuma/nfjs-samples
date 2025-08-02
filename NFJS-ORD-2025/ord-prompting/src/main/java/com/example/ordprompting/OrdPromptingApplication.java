package com.example.ordprompting;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrdPromptingApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrdPromptingApplication.class, args);
  }

  @Bean
  ApplicationRunner go(ChatClient.Builder chatClientBuilder) {
    return args -> {
      var chatClient = chatClientBuilder.build();

      var answer = chatClient.prompt()
          .system("""
              Think step by step, but only keep a minimum draft for each thinking step, with 5 words at most. Return the answer at the end of the response after a separator ####.
              
              """)
          .user("""
              Which is a faster way to get to work?
              Option 1: Take a 1000 minute bus, then a half hour train, and finally a 10 minute bike ride.
              Option 2: Take an 800 minute bus, then an hour train, and finally a 30 minute bike ride.
              """)
          .call()
          .content();

      System.err.println("ANSWER:\n========\n" + answer);
    };
  }

}
