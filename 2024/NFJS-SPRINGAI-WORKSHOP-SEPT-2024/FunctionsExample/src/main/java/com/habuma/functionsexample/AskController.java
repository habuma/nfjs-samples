package com.habuma.functionsexample;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder
        .build();
  }

  @PostMapping("/ask")
  String ask(@RequestParam("city") String city) {
    return chatClient.prompt()
        .user("What is the current time in " + city)
        .functions("currentTimeFunction")
        .call()
        .content();
  }

}
