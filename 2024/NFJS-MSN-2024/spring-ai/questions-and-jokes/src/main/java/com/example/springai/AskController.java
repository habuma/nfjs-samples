package com.example.springai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    return new Answer(chatClient.call(question.question()));
  }

}
