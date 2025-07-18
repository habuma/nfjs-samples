package com.example.springaiobservability;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    return chatClient.prompt()
        .user(question.question())
        .call()
        .entity(Answer.class);
  }

}
