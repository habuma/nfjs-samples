package com.example.observingai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(ChatClient.Builder clientBuilder, VectorStore vectorStore) {
    this.chatClient = clientBuilder
        .defaultAdvisors(QuestionAnswerAdvisor.builder(vectorStore).build())
        .build();
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    var chatMemoryRepo = new InMemoryChatMemoryRepository();
    var chatMemory = MessageWindowChatMemory.builder()
        .chatMemoryRepository(chatMemoryRepo)
        .build();
    var chatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

    return chatClient.prompt()
        .advisors(chatMemoryAdvisor)
        .user(question.question())
        .call()
        .entity(Answer.class);
  }

}
