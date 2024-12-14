package com.example.nfjsaiworkshop;

import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AskController {

    private final ChatClient chatClient;

//    @Value("classpath:/questionTempalte.st")
//    Resource questionTemplate;

//    @Value("classpath:/document.txt")
//    Resource documentResource;

    public AskController(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(
//                        new SimpleLoggerAdvisor(),
                        new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    @PostMapping("/ask")
    public Answer ask(@RequestBody Question question) {
        String conversationId = question.conversationId() != null
                ? question.conversationId() : "default";

        var chatMemory = new InMemoryChatMemory();
        var chatAdvisor = PromptChatMemoryAdvisor.builder(chatMemory)
                .withConversationId(conversationId)
                .build();

//        return chatClient.prompt(question.question())
//                .call()
//                .content();

//        List<Document> documents = new TikaDocumentReader(documentResource).read();
//        Document document = documents.getFirst();
//        String documentText = document.getContent();

        return chatClient.prompt()
//                .system(systemSpec -> systemSpec
//                        .text(questionTemplate)
//                        .param("document", documentText))
                .user(question.question())
                .advisors(chatAdvisor)
                .call()
                .entity(Answer.class);
    }

}
