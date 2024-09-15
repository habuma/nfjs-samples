package com.habuma.nfjsai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.around.CacheAroundAdvisor;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.document.Document;
import org.springframework.ai.model.ModelOptionsUtils;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
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

  @Value("classpath:/rulesExpert.st")
  Resource expertTemplate;

  public AskController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
    this.chatClient = chatClientBuilder.build();
    this.vectorStore = vectorStore;
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    List<Document> documents = vectorStore.similaritySearch(
        SearchRequest.query(question.question())
            .withTopK(2));
    String rulesString = documents.stream()
        .map(Document::getContent)
        .collect(Collectors.joining("\n\n"));

    System.err.println("DOCUMENTS: " + documents.size());
    System.err.println("RULES: " + rulesString);

    ResponseEntity<ChatResponse, Answer> re = chatClient.prompt()
        .user(question.question())
        .system(systemSpec -> systemSpec.text(expertTemplate)
              .param("rules", rulesString))


//        .advisors(
//            new SimpleLoggerAdvisor(ModelOptionsUtils::toJsonString, ModelOptionsUtils::toJsonString),
//            new CacheAroundAdvisor(vectorStore))
        .functions("timeFunction")
        .call()
        .responseEntity(Answer.class);

    ChatResponse chatResponse = re.response();
    Usage usage = chatResponse.getMetadata().getUsage();
    System.err.println("Usage: " + usage.getPromptTokens() + " / " + usage.getGenerationTokens() + " / " + usage.getTotalTokens());

    return re.entity();
  }

}
