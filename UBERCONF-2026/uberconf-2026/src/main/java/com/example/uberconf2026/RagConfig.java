package com.example.uberconf2026;

import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class RagConfig {

  @Value("file:///Users/habuma/Documents/BoardGameRules/FantasticFactories.pdf")
  Resource resource;

  @Bean
  ApplicationRunner loadDocument(VectorStore vectorStore) {
    return args -> {
      System.err.println("LOADING DOCUMENT");
      var reader = new TikaDocumentReader(resource);
      var splitter = TokenTextSplitter.builder().build();

      vectorStore.accept(splitter.apply(reader.get()));

      System.err.println("DOCUMENT LOADED");
    };

  }

}
