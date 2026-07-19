package com.example.uberconf2026;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Uberconf2026Application {

  public static void main(String[] args) {
    SpringApplication.run(Uberconf2026Application.class, args);
  }

//  @Bean
//  ApplicationRunner go(ChatClient.Builder clientBuilder) {
//    return args -> {
//      var chatClient = clientBuilder.build();
//
//      var answer = chatClient.prompt()
//          .user("Tell me a joke")
//          .system("Answer in the style of Jerry Seinfeld")
//          .call()
//          .entity(Joke.class);
//
//      System.err.println(answer);
//    };
//  }

  @Bean
  ApplicationRunner go(ChatClient chatClient) {
    return args -> {
      System.out.println("How can I help?\n");

      try (Scanner scanner = new Scanner(System.in)) {
        while (true) {
          System.out.print("> ");
          if (!scanner.hasNextLine()) break; // to avoid infinite loops in tests
          var input = scanner.nextLine();
          if (input.isBlank()) continue; // allows user to hit return without error
          var response = chatClient.prompt(input)
              .advisors(spec -> spec.param(ChatMemory.CONVERSATION_ID, "DEMO"))
              .call()
              .chatResponse();

          var totalTokens = response.getMetadata().getUsage().getTotalTokens();
          System.err.println(totalTokens);

          var answer = response.getResult().getOutput().getText();
          System.out.println("\n - " + answer);
        }
      }
    };
  }

}
