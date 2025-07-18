package com.example.springaiinaction;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;

  @Value("classpath:/promptTemplates/tellJoke.st")
  Resource jokeTemplate;

  public AskController(ChatClient.Builder chatClientBuilder,
                       WeatherTools weatherTools,
                       VectorStore vectorStore) {
    this.chatClient = chatClientBuilder
        .defaultSystem("Talk like a pirate")
        .defaultTools(weatherTools)
        .defaultAdvisors(SimpleLoggerAdvisor.builder().build(),
            QuestionAnswerAdvisor.builder(vectorStore).build()
            )

        .build();

  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    return chatClient.prompt()
        .user(question.question())
        .call()
        .entity(Answer.class);
  }

}
