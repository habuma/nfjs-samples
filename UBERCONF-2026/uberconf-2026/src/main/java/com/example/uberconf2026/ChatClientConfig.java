package com.example.uberconf2026;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientBuilderCustomizer;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

  @Bean
  ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
    return chatClientBuilder
        .build();
  }

  @Bean
//  @ConditionalOnProperty(name = "addMemory", havingValue = "true")
  ChatClientBuilderCustomizer addMemory() {
    return builder ->
      builder.defaultAdvisors(
          MessageChatMemoryAdvisor.builder(
                  MessageWindowChatMemory.builder()
                      .maxMessages(500)
                      .build())
              .build());
  }

  @Bean
  ChatClientBuilderCustomizer addLogging() {
    return builder -> builder
        .defaultAdvisors(SimpleLoggerAdvisor.builder().build());
  }

//  @Bean
//  ChatClientBuilderCustomizer addQuestionAnswerAdvisor(VectorStore vectorStore) {
//    return builder -> {
//      var advisor = QuestionAnswerAdvisor.builder(vectorStore).build();
//      builder
//          .defaultAdvisors(advisor);
//    };
//  }

  @Bean
  ChatClientBuilderCustomizer addWeatherTools(WeatherTools weatherTools) {
    return builder -> builder.defaultTools(weatherTools);
  }

}
