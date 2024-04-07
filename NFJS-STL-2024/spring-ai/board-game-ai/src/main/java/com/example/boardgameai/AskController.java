package com.example.boardgameai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@RestController
public class AskController {

  private final ChatClient chatClient;

  public AskController(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  @Value("classpath:/promptTemplates/boardGameQuestions.st")
  private Resource askTemplateResource;

  @Value("classpath:/burger_battle.txt")
  private Resource bbRulesResource;

  @PostMapping("/ask")
  public Answer ask(@RequestBody Question question) {
    Prompt prompt = new PromptTemplate(askTemplateResource)
        .create(Map.of(
            "gameName", question.gameName(),
            "question", question.question(),
            "rules", getRules()));
    String answerText = chatClient.call(prompt).getResult().getOutput().getContent();
    return new Answer(question.gameName(), answerText);
  }

  private String getRules() {
    try {
      InputStream inputStream = bbRulesResource.getInputStream();
      return FileCopyUtils.copyToString(new InputStreamReader(inputStream)); // <3>
    } catch (IOException e) {
      return "";                                            // <4>
    }
  }

}
