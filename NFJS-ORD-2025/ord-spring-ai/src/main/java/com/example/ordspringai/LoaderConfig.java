package com.example.ordspringai;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LoaderConfig {

//  @Bean
//  VectorStore vectorStore(EmbeddingModel embeddingModel) {
//    return SimpleVectorStore.builder(embeddingModel).build();
//  }

  @Value("file:///Users/habuma/Documents/BoardGameRules/BurgerBattle-rules.txt")
  Resource resource;

  @Bean
  ApplicationRunner loader(VectorStore vectorStore) {
    return args -> {
      var reader = new TikaDocumentReader(resource);
      var splitter = TokenTextSplitter.builder().build();

      vectorStore.accept(splitter.apply(reader.get()));

      System.err.println("Loaded documents into vector");
    };
  }

}
