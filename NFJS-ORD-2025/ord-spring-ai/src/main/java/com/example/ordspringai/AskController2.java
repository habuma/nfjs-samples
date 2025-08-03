package com.example.ordspringai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController2 {

  private final ChatClient chatClient;

  public AskController2(
      ChatClient.Builder chatClientBuilder,
      WeatherTools weatherTools) {
    this.chatClient = chatClientBuilder
        .defaultTools(weatherTools)
        .defaultAdvisors(MessageChatMemoryAdvisor
            .builder(MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .build())
            .build())
        .build();
  }

  @PostMapping("/ask2")
  public Answer ask2(
      @RequestBody Question question,
      @RequestHeader(name="X-Conversation-Id",
          defaultValue = ChatMemory.DEFAULT_CONVERSATION_ID) String conversationId) {
    return chatClient.prompt()
        .user(question.question())
        .advisors(advisors -> advisors
            .param(ChatMemory.CONVERSATION_ID, conversationId))
        .call()
        .entity(Answer.class);
  }
  
}
