package com.enterprise.ai.assistant.Service;

import com.enterprise.ai.assistant.Entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService
{
    private ChatClient chatClient;

    @Value("classpath:/prompts/user-message.st")
    private Resource usermessage;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemmessage;


    public ChatServiceImpl(ChatClient.Builder builder)
    {
        this.chatClient = builder.build();
    }


    @Override
    public String chat(String query)
    {

        /*
           Call the LLM for response

           String content = chatClient
                   .prompt()
                   .user(prompt)
                   .system("As as expert in cricket.")
                   .call()
                   .content();
         */

    /*
    String prompt = "tell me about virat kohli?";

    Prompt prompt1 = new Prompt(query, OpenAiChatOptions.builder()
            .model("gpt-4o-mini")
            .temperature(0.3)
            .maxTokens(100)
            .build());
    */

        Prompt prompt = new Prompt(query);

        // Modify this prompt and extra things to prompt make it more interactive.
        String queryStr = "As an expert in coding and programming. Always write program in java. Now reply for this question :{query}";

        var tutorials = chatClient
                .prompt()
                .user(user -> user
                        .text(queryStr)
                        .param("query", query))
                .call()
                .content();

        return tutorials;
    }


    public String chatTemplate()
    {
        // Step 1: Create Prompt Template
//        PromptTemplate strTemplate = PromptTemplate.builder()
//                .template("What is {techName}? Tell me an example of {exampleName}.")
//                .build();

        // Step 2: Render Template Variables
//        String renderMessage = strTemplate.render(Map.of(
//                "techName", "Spring",
//                "exampleName", "Spring Boot"
//        ));

        // Step 3: Pass Generated Prompt to Gemini
//        return chatClient.prompt()
//                .user(renderMessage)
//                .call()
//                .content();

        // Step 1: Create System Prompt
//        var systemPromptTemplate = SystemPromptTemplate.builder()
//                .template("You are a helpful coding assistant. You are an expert in coding.")
//                .build();
//
//        var systemMessage = systemPromptTemplate.createMessage();

        // Step 2: Create User Prompt
//        var userPromptTemplate = PromptTemplate.builder()
//                .template("What is {techName}? Tell me also about {techExample}.")
//                .build();
//
//        var userMessage = userPromptTemplate.createMessage(Map.of(
//                "techName", "Spring",
//                "techExample", "Spring Exception"
//        ));

        // Step 3: Combine System and User Messages
//        Prompt prompt = new Prompt(systemMessage, userMessage);

        // Step 4: Send Request to Gemini
//        return this.chatClient.prompt(prompt)
//                .call()
//                .content();


        return this.chatClient
                .prompt()
//                .advisors(new SimpleLoggerAdvisor())
                .system(system ->
                        system.text(this.systemmessage))
                .user(user -> user
                        .text(usermessage)
                        .param("concept", "Spring Framework"))
                .call()
                .content();

    }

    @Override
    public Flux<String> streamChat(String query)
    {
        return this.chatClient
                .prompt()
                .system(system -> system.text(this.systemmessage))
                .user(user -> user.text(this.usermessage)
                        .param("concept", query))
                .stream()
                .content();
    }

}
