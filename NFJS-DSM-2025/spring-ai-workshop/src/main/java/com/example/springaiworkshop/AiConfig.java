package com.example.springaiworkshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
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
public class AiConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(AiConfig.class);

  @Value("file:///Users/habuma/Documents/2025-nfl-rulebook-final.pdf")
  Resource documentResource;

//  @Bean
//  VectorStore vectorStore(EmbeddingModel embeddingModel) {
//    return SimpleVectorStore.builder(embeddingModel).build();
//  }

  @Bean
  ApplicationRunner go(ChatClient.Builder clientBuilder,
                       VectorStore vectorStore) {
    return args -> {
      var reader = new TikaDocumentReader(documentResource);
      var splitter = TokenTextSplitter.builder().build();
      vectorStore.accept(splitter.apply(reader.get()));
      LOGGER.info("Vector store loaded with some documents");
    };
  }

}
