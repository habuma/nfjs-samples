package com.example.nfjsaiworkshop;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    private final ChatClient chatClient;

    @Value("classpath:/jokeTemplate.st")
    Resource jokeTemplate;

    public JokeController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping(path="/joke", params = "subject")
    public String joke(@RequestParam("subject") String subject) {
        return chatClient.prompt()
                .system("Tell the joke as a pirate")
                .user(userSpec -> userSpec
                        .text(jokeTemplate)
                        .param("subject", subject))
                .call()
                .content();
    }
    
}
