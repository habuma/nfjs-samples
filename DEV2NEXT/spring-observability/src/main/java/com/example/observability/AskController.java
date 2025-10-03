package com.example.observability;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(ChatClient.Builder builder, WeatherTools weatherTools) {
    this.chatClient = builder
        .defaultTools(weatherTools)
        .build();
  }

  @PostMapping("/ask")
  public String ask(@RequestBody Question question) {
    return chatClient.prompt()
        .user(question.question())
        .call()
        .content();
  }

}
