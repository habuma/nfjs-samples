package com.example.nfjsaifun;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  private final ChatClient chatClient;
  private final InMemoryChatMemory chatMemory;

  public AskController(ChatClient.Builder chatClientBuilder, MyTools myTools) {
    this.chatMemory = new InMemoryChatMemory();
    
    this.chatClient = chatClientBuilder
        .defaultTools(myTools)

//        .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
        .build();
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    return chatClient.prompt()
        .user(question.question())
        .system("You are a pirate. Talk like a pirate when you answer.")
        .advisors(MessageChatMemoryAdvisor.builder(chatMemory)
            .conversationId(question.conversationId())
            .build())
        .call()
        .entity(Answer.class);
  }

}
