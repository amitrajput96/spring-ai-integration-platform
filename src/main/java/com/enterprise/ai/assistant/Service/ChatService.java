package com.enterprise.ai.assistant.Service;

import com.enterprise.ai.assistant.Entity.Tut;

import java.util.List;

public interface ChatService
{
    List<Tut> chat(String query);
}
