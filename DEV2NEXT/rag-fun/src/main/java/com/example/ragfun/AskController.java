package com.example.ragfun;

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

  public AskController(ChatClient.Builder builder, VectorStore vectorStore) {
    this.chatClient = builder
        .defaultAdvisors(
//            SimpleLoggerAdvisor.builder().build(),
            QuestionAnswerAdvisor.builder(vectorStore).build())
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
