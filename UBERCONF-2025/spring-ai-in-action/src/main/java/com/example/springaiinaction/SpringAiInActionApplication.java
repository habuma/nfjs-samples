package com.example.springaiinaction;

import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class SpringAiInActionApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringAiInActionApplication.class, args);
  }

  @Value("file:///Users/habuma/Documents/2024-nfl-rulebook.pdf")
  Resource rulebook;

  @Bean
  ApplicationRunner go(VectorStore vectorStore) {
    return args -> {

      TikaDocumentReader reader = new TikaDocumentReader(rulebook);
      TokenTextSplitter splitter = new TokenTextSplitter();

      vectorStore.accept(splitter.apply(reader.get()));
      System.err.println("LOADED DOCUMENTS");
    };
  }

}
