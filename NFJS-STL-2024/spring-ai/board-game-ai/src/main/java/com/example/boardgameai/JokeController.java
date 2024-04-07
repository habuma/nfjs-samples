package com.example.boardgameai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JokeController {

  private static final String JOKE_TEMPLATE =
      """
      Tell me a joke about {subject}
      """;

  private final ChatClient chatClient;

  public JokeController(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  @PostMapping("/joke")
  public String getJoke(@RequestBody Subject subject) {

    PromptTemplate jokeTemplate = new PromptTemplate(JOKE_TEMPLATE);
    Prompt prompt = jokeTemplate.create(
        Map.of("subject", subject.subject()));

    ChatResponse response = chatClient.call(prompt);

    Long promptTokens = response.getMetadata().getUsage().getPromptTokens();
    Long genTokens = response.getMetadata().getUsage().getGenerationTokens();

    System.err.println("Prompt tokens: " + promptTokens);
    System.err.println("Generation tokens: " + genTokens);

    return response.getResult().getOutput().getContent();
  }

  static record Subject(String subject) {}
}
