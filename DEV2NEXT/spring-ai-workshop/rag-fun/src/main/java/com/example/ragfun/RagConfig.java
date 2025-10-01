package com.example.ragfun;

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

  @Value("file:///Users/habuma/Documents/BoardGameRules/BurgerBattle-rules.txt")
  Resource docResource;

  @Bean
  ApplicationRunner loadDoc(VectorStore vectorStore) {
    return args -> {
      var reader = new TikaDocumentReader(docResource);
      var splitter = TokenTextSplitter.builder().build();
      vectorStore.accept(splitter.apply(reader.get()));
      System.err.println("Loaded documents into vector store");
    };
  }

}
