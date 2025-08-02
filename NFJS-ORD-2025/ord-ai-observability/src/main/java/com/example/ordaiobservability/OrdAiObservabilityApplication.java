package com.example.ordaiobservability;

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
public class OrdAiObservabilityApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrdAiObservabilityApplication.class, args);
  }

  @Value("file:///Users/habuma/Documents/BoardGameRules/ForestShuffle.pdf")
  private Resource resource;

  @Bean
  ApplicationRunner go(VectorStore vectorStore) {
    return args -> {
      var reader = new TikaDocumentReader(resource);
      var splitter = new TokenTextSplitter();
      vectorStore.accept(splitter.apply(reader.get()));
      System.err.println(" - Vector store populated with");
    };
  }
}
