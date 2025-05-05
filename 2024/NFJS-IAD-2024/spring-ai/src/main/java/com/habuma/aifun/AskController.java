package com.habuma.aifun;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AskController {

  private final ChatClient chatClient;
  private final VectorStore vectorStore;

  @Value("classpath:/systemPromptTemplate.st")
  private Resource systemPromptTemplate;

  public AskController(ChatClient.Builder ccb, VectorStore vectorStore) {
    this.vectorStore = vectorStore;
    this.chatClient = ccb.build();
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {

    List<Document> documents = vectorStore.similaritySearch(
        SearchRequest.query(question.question())
            .withTopK(3)
    );

    String content = documents.stream()
        .map(Document::getContent)
        .collect(Collectors.joining("\n"));

    return new Answer(chatClient.prompt()
        .user("Question: " + question.question())
        .system(systemSpec -> systemSpec
            .text(systemPromptTemplate)
            .param("rules", content)
        )
        .call()
        .content());

  }

}
