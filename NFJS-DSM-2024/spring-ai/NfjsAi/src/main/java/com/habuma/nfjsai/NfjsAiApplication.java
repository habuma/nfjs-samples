package com.habuma.nfjsai;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class NfjsAiApplication {

  public static void main(String[] args) {
    SpringApplication.run(NfjsAiApplication.class, args);
  }

  @Value("classpath:/Carcassonne_Rules.pdf")
  Resource rulesResource;

//  @Bean
  ApplicationRunner go(VectorStore vectorStore) {
    return args -> {
      System.out.println("STARTED");

      List<Document> documents = new TikaDocumentReader(rulesResource).read();
      TokenTextSplitter textSplitter = new TokenTextSplitter();
      List<Document> splitDocuments = textSplitter.apply(documents);
      System.err.println("Split documents: " + splitDocuments.size());

      vectorStore.add(splitDocuments);

      System.out.println("FINISHED");
    };
  }

}
