package com.example.springaioptions;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;

  @Value("classpath:/promptTemplates/systemPrompt.st")
  Resource systemPrompt;

  public AskController(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    return this.chatClient.prompt()
        .user(question.question())
        .advisors(SimpleLoggerAdvisor.builder()
            .build())
        .call()
        .entity(Answer.class);
  }

}
