package com.example.observingai;

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
public class ObservingAiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ObservingAiApplication.class, args);
  }

  @Value("file:///Users/habuma/Documents/2025-nfl-rulebook-final.pdf")
  Resource documentResource;

  @Bean
  ApplicationRunner go(VectorStore vectorStore) {
    return args -> {
      var reader = new TikaDocumentReader(documentResource);
      var splitter = TokenTextSplitter.builder().build();

      vectorStore.accept(splitter.apply(reader.get()));

      System.err.println("Document ingested!");
    };
  }

}
