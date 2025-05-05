package com.habuma.nfjsworkshop;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.ai.document.Document;
import org.springframework.ai.model.ModelOptionsUtils;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AskController {
  private final ChatClient chatClient;
  private final VectorStore vectorStore;

  @Value("classpath:/gameRulesExpert.st")
  Resource systemPromptTemplate;


  public AskController(ChatClient.Builder chatClientBuilder,
                       VectorStore vectorStore) {
    this.chatClient = chatClientBuilder
        .build();

    this.vectorStore = vectorStore;
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    List<Document> documents = vectorStore.similaritySearch(question.question());

    String rulesText = documents.stream()
        .map(Document::getContent)
        .collect(Collectors.joining("\n"));

    ChatMemory chatMemory = new InMemoryChatMemory();

    return chatClient.prompt()
        .user(question.question())
//        .system(systemPromptTemplate)
        .system(systemSpec -> {
          systemSpec
              .text(systemPromptTemplate)
              .param("rules", rulesText);
        })
        .advisors(
            new SimpleLoggerAdvisor(
            ModelOptionsUtils::toJsonString, ModelOptionsUtils::toJsonString),
            new MessageChatMemoryAdvisor(
                chatMemory,
                "yyyyyyy",
                100))
        .call()
        .entity(Answer.class);
  }
}
