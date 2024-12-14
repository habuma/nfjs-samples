package com.example.nfjsaiworkshop;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final ChatClient chatClient;

    public WeatherController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                .defaultFunctions("weatherFunction")
                .build();
    }

    @PostMapping("/weather")
    public Answer ask(@RequestBody Question question) {
        return chatClient.prompt()
                .user(question.question())
                .call()
                .entity(Answer.class);
    }

}
