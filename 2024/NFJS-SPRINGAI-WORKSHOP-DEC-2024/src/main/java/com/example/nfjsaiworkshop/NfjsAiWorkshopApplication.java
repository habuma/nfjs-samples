package com.example.nfjsaiworkshop;
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
public class NfjsAiWorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(NfjsAiWorkshopApplication.class, args);
    }

    @Value("classpath:/2024-nfl-rulebook.pdf")
    Resource nflRules;

    @Bean
    ApplicationRunner go(VectorStore vectorStore) {
        return args -> {
            var reader = new TikaDocumentReader(nflRules);
            var splitter = new TokenTextSplitter();
            vectorStore.accept(splitter.apply(reader.read()));
            System.err.println("Vector store populated");
        };
    }

}
