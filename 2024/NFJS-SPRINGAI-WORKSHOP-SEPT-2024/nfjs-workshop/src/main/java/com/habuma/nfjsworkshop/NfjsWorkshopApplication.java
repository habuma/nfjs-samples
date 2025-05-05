package com.habuma.nfjsworkshop;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.util.List;

@SpringBootApplication
public class NfjsWorkshopApplication {

  public static void main(String[] args) {
    SpringApplication.run(NfjsWorkshopApplication.class, args);
  }

  @Value("classpath:/BurgerBattle-rules.txt")
  Resource burgerBattleRules;

  @Bean
  VectorStore vectorStore(EmbeddingModel embeddingModel) {
    return new SimpleVectorStore(embeddingModel);
  }

  @Bean
  ApplicationRunner go(VectorStore vectorStore) {
    return args -> {
      List<Document> documents = new TikaDocumentReader(burgerBattleRules).get();
      Document bbRulesDoc = documents.getFirst();
      List<Document> split = new TokenTextSplitter().split(bbRulesDoc);
      vectorStore.add(split);

      System.err.println("Vector store has " + split.size() + " documents");
    };
  }

}
