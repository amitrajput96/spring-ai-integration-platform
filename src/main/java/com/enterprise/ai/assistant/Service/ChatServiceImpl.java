package com.enterprise.ai.assistant.Service;

import com.enterprise.ai.assistant.Entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService
{
    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder)
    {
        this.chatClient = builder.build();
    }

    @Override
    public List<Tut> chat(String query)
    {
        String prompt = "Tell me about virat kohli ?";

        //Call the LLM for the Response

//       String content = chatClient
//                .prompt()
//                .user(prompt)
//                .system("As an Expert in Cricket.")
//                .call()
//                .content();

//        Prompt prompt1 = new Prompt(prompt);
//        var content = chatClient
//                .prompt(prompt1)
//                .call()
//                .content();

        Prompt prompt1 = new Prompt(prompt);
        List<Tut> tutorial = chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {
                });

        return tutorial;
    }
}
