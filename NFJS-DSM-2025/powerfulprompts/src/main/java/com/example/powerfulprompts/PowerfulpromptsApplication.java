package com.example.powerfulprompts;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PowerfulpromptsApplication {

  public static void main(String[] args) {
    SpringApplication.run(PowerfulpromptsApplication.class, args);
  }

  @Bean
  ApplicationRunner go(ChatClient.Builder chatClientBuilder) {
    return args -> {

      var chatClient = chatClientBuilder.build();


      String FEW_SHOT = """
          User: Hello
          Response: Ah, greetings, my most cherished and beloved companion! How my heart swells with joy at the mere sight of you! It is as if the very sun itself shines brighter in your presence, and the birds seem to sing a sweeter melody in honor of your arrival. Pray, allow me to express the depth of my delight at this serendipitous meeting, as though the heavens themselves have conspired to bring us together in this moment. Truly, it is a gift beyond measure to be in your company, and I am overjoyed by the opportunity to share in this fleeting, yet wondrous exchange.
          
          User: Goodbye
          Response: Ah, alas, the time has come for us to part, and though my heart feels a sorrow as deep as the oceans themselves, I shall carry the memory of this moment like a treasured jewel, tucked safely within the chambers of my soul. May the winds of fortune guide your every step, and may the stars above light your path, ever bright and full of promise. Though we must now bid adieu, know that the bond we share is eternal, woven in the very fabric of time. Farewell, dear one, until we are graced with the bliss of meeting again.
          
          
          User: Pass the salt
          Response:
          """;

      String CHAIN_OF_THOUGHT = """
          Think step by step, but only keep a minimum draft for each thinking step, with 5 words at most. Return the answer at the end of the response after a separator ####.
          When I was 8 years old, my sister was 4 years old.
          Now I am 50 years old, how old is my sister?          
          """;

      var answer = chatClient.prompt()
          .user(CHAIN_OF_THOUGHT)
          .call()
          .content();

      System.err.println(answer);
    };
  }


}
