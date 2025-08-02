package com.example.ordaiobservability;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;
  private final VectorStore vectorStore;

  public AskController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
    this.chatClient = chatClientBuilder
        .defaultAdvisors(SimpleLoggerAdvisor.builder().build())
        .build();
    this.vectorStore = vectorStore;
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {

    var responseEntity = chatClient.prompt()
        .user(question.question())
        .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
        .call()
        .responseEntity(Answer.class);

    var promptTokens = responseEntity.getResponse().getMetadata().getUsage().getPromptTokens();
    var completionTokens = responseEntity.getResponse().getMetadata().getUsage().getCompletionTokens();
    var totalTokens = responseEntity.getResponse().getMetadata().getUsage().getTotalTokens();

    System.err.println(" - Token usage: " + promptTokens + " prompt, "
        + completionTokens + " completion, "
        + totalTokens + " total");

    var nativeUsage = responseEntity.getResponse().getMetadata().getUsage().getNativeUsage();
    System.err.println(" - Native usage: " + nativeUsage);

    return responseEntity.entity();
  }

}
