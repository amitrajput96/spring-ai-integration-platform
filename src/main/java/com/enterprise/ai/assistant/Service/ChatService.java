package com.enterprise.ai.assistant.Service;

import reactor.core.publisher.Flux;

public interface ChatService
{
      String chat(String query);
      public String chatTemplate();

      Flux<String> streamChat(String query);
}
