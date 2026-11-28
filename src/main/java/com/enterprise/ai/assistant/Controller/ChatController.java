package com.enterprise.ai.assistant.Controller;

import com.enterprise.ai.assistant.Entity.Tut;
import com.enterprise.ai.assistant.Service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping
public class ChatController
{
    // private ChatClient chatClient;

    private ChatService chatService;

    private ChatClient geminiAIChatModel;

    // private ChatClient ollamaChatModel;


    // Constructor using ChatClient.Builder

    // public ChatController(ChatClient.Builder builder) {
    //     this.chatClient = builder.build();
    // }


    // Constructor using Google GenAI and Ollama Chat Models

    // public ChatController(
    //         @Qualifier("googleGenAiChatModel") GoogleGenAiChatModel googleGenAiChatModel,
    //         @Qualifier("ollamaChatModel") OllamaChatModel ollamaChatModel) {

    //     this.googleGenAiChatClient =
    //             ChatClient.builder(googleGenAiChatModel).build();

    //     this.ollamaChatClient =
    //             ChatClient.builder(ollamaChatModel).build();
    // }


    // Implementing Chat Model

    // public ChatController(GoogleGenAiChatModel geminiAIChatModel) {
    //     System.out.println(geminiAIChatModel.getClass().getName());

    //     this.geminiAIChatModel =
    //             ChatClient.builder(geminiAIChatModel).build();
    // }


    // Constructor using ChatModel

    // public ChatController(ChatModel chatModel) {
    //     System.out.println(chatModel.getClass().getName());

    //     this.chatClient = ChatClient.builder(chatModel).build();
    // }


    // Constructor Injection using ChatService

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    // Chat API using Gemini AI

    // @GetMapping("/chat")
    // public ResponseEntity<String> chat(
    //         @RequestParam(value = "q", required = true) String q) {

    //     var response = geminiAIChatModel
    //             .prompt(q)
    //             .call()
    //             .content();

    //     return ResponseEntity.ok(response);
    // }


    // Chat API using ChatClient

    // @GetMapping("/chat")
    // public ResponseEntity<String> chat(
    //         @RequestParam(value = "q", required = true) String q) {

    //     var response = chatClient
    //             .prompt(q)
    //             .call()
    //             .content();

    //     return ResponseEntity.ok(response);
    // }


    // Chat API returning List of Tutorials

    // @GetMapping("/chat")
    // public ResponseEntity<List<Tut>> chat(
    //         @RequestParam(value = "q", required = true) String q) {

    //     return ResponseEntity.ok(chatService.chat(q));
    // }


    // Active Chat API using ChatService

    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q", required = true) String q) {

        return ResponseEntity.ok(chatService.chat(q));
    }

    @GetMapping(value = "/stream-chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChat(@RequestParam("q") String query) {
        return this.chatService.streamChat(query);
    }
}
