package com.enterprise.ai.assistant.Controller;

import com.enterprise.ai.assistant.Entity.Tut;
import com.enterprise.ai.assistant.Service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class ChatController
{

//    private ChatClient chatClient;

    private ChatService chatService;

//    private ChatClient geminiAIChatModel;
//    private ChatClient ollamaChatModel;

//    public ChatController(ChatClient.Builder builder)
//    {
//        this.chatClient = builder.build();
//    }

//    public ChatController(@Qualifier("googleGenAiChatModel") GoogleGenAiChatModel googleGenAiChatModel, @Qualifier("ollamaChatModel") OllamaChatModel ollamaChatModel)
//    {
//        this.googleGenAiChatClient = ChatClient.builder(googleGenAiChatModel).build();
//
//        this.ollamaChatClient = ChatClient.builder(ollamaChatModel).build();
//    }

    //implemenenting Chat Model
//    public ChatController(GoogleGenAiChatModel geminiAIChatModel)
//    {
//        System.out.println(geminiAIChatModel.getClass().getName());
//        this.geminiAIChatModel = ChatClient.builder(geminiAIChatModel).build();
//    }

//    public ChatController(ChatModel chatModel)
//    {
//        System.out.println(chatModel.getClass().getName());
//        this.chatClient = ChatClient.builder(chatModel).build();
//    }

    public ChatController(ChatService chatService)
    {
        this.chatService = chatService;
    }

    //    @GetMapping("/chat")
//    public ResponseEntity<String> chat(@RequestParam(value="q", required = true) String q)
//    {
//        var respone = geminiAIChatModel
//                .prompt(q)
//                .call()
//                .content();
//        return ResponseEntity.ok(respone);
//    }

//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(@RequestParam(value="q", required = true) String q)
//    {
//        var respone = chatClient
//                .prompt(q)
//                .call()
//                .content();
//        return ResponseEntity.ok(respone);
//    }

    @GetMapping("/chat")
    public ResponseEntity<List<Tut>> chat(@RequestParam(value="q", required = true) String q)
    {
        return ResponseEntity.ok(chatService.chat(q));
    }
}
