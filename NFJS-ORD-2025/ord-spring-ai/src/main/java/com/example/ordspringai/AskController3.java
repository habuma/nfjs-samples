package com.example.ordspringai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController3 {

  private final ChatClient chatClient;

  public AskController3(
      ChatClient.Builder chatClientBuilder,
      VectorStore vectorStore) {
    this.chatClient = chatClientBuilder
        .defaultAdvisors(MessageChatMemoryAdvisor
            .builder(MessageWindowChatMemory.builder()
                .chatMemoryRepository(new InMemoryChatMemoryRepository())
                .build())
            .build(),
            QuestionAnswerAdvisor.builder(vectorStore).build())
        .build();
  }

  @PostMapping("/ask3")
  public Answer ask3(
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
