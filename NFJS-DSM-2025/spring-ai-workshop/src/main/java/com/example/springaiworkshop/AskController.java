package com.example.springaiworkshop;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.Charset;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(
      ChatClient.Builder clientBuilder,
      VectorStore vectorStore,
      WeatherTools weatherService) {

      var chatMemoryRepository = new InMemoryChatMemoryRepository();
      var chatMemory = MessageWindowChatMemory.builder()
          .chatMemoryRepository(chatMemoryRepository).build();
      var chatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

      this.chatClient = clientBuilder
          .defaultTools(weatherService)
          .defaultAdvisors(QuestionAnswerAdvisor
              .builder(vectorStore)
              .build(),
              chatMemoryAdvisor)
          .build();
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    return chatClient.prompt()
        .user(question.question())
        .call()
        .entity(Answer.class);



//    var responseEntity = chatClient.prompt()
//        .user(question.question())
//        .call()
//        .responseEntity(Answer.class);
//
//    var usage = responseEntity.getResponse().getMetadata().getUsage();
//    System.err.println("Prompt tokens: " + usage.getPromptTokens());
//    System.err.println("Completion tokens: " + usage.getCompletionTokens());
//    System.err.println("Total tokens: " + usage.getTotalTokens());
//
//    return responseEntity.getEntity();
  }

}
