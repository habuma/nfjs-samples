package com.example.springai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JokeController {

  private final ChatClient chatClient;

  @Value("classpath:/jokeTemplate.st")
  Resource jokeTemplateResource;


  public JokeController(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  @PostMapping("/joke")
  public String joke(@RequestBody Subject subject) {
    Prompt prompt = new PromptTemplate(jokeTemplateResource)
        .create(Map.of("subject", subject.subject()));

    return chatClient.call(prompt).getResult().getOutput().getContent();
  }

  public record Subject(String subject) { }

}
