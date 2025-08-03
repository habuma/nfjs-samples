package com.example.ordspringai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskController {

  @Value("classpath:/promptTemplates/systemPrompt.st")
  Resource talkLikeTemplateResource;

  private final ChatClient chatClient;

  public AskController(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    var responseEntity = chatClient.prompt()
        .user(question.question())
        .system(systemSpec -> systemSpec
            .text(talkLikeTemplateResource)
            .param("talkLike", question.talkLike()))
        .call()
        .responseEntity(Answer.class);

    var totalTokens = responseEntity
        .getResponse().getMetadata().getUsage().getTotalTokens();
    System.err.println("Total tokens used: " + totalTokens);

    var model = responseEntity.getResponse().getMetadata().getModel();
    System.err.println("Model used: " + model);
    return responseEntity.getEntity();
  }

}
