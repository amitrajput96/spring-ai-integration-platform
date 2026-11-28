package com.enterprise.ai.assistant.Config;


import com.enterprise.ai.assistant.Advisors.TokenPrintAdvisor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// import org.springframework.ai.ollama.OllamaChatModel;

@Configuration
public class AiConfig
{

    private Logger logger = LoggerFactory.getLogger(AiConfig.class);

    // Gemini AI Chat Model
    // @Bean(name = "geminiAIChatModel")
    // public ChatClient geminiAIChatModel(GoogleGenAiChatModel chatModel) {
    //     return ChatClient.builder(chatModel).build();
    // }

    // Ollama AI Chat Model
    // @Bean(name = "ollamaAIChatModel")
    // public ChatClient ollamaAIChatModel(OllamaChatModel chatModel) {
    //     return ChatClient.builder(chatModel).build();
    // }

    // Default ChatClient Configuration
    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory)
    {
        this.logger.info("Chat Memeory Implementation Class : "+chatMemory.getClass().getName());

        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();

        return builder
//                .defaultAdvisors(new TokenPrintAdvisor(),new SimpleLoggerAdvisor(),new SafeGuardAdvisor(List.of("games")))
//                .defaultAdvisors(messageChatMemoryAdvisor,new TokenPrintAdvisor(),new SafeGuardAdvisor(List.of("games")))
                .defaultAdvisors(messageChatMemoryAdvisor,new SimpleLoggerAdvisor(),new SafeGuardAdvisor(List.of("games")))
                .defaultSystem("you are helpful coding assistance. you are expert in coding.")
                .defaultOptions(GoogleGenAiChatOptions.builder()
                                .model("gemini-3.5-flash")
                                .temperature(0.3)
                                .maxTokens(200)
                )
                .build();
    }
}
