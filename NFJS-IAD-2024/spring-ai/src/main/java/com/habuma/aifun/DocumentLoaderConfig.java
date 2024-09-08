package com.habuma.aifun;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
public class DocumentLoaderConfig {

  @Value("classpath:/Carcassonne_Rules.pdf")
  private Resource document;

  @Bean
  ApplicationRunner go(VectorStore vectorStore) {
    return args -> {
      TikaDocumentReader reader = new TikaDocumentReader(document);
      TokenTextSplitter splitter = new TokenTextSplitter();
      vectorStore.accept(splitter.split(reader.get()));
    };
  }

}
