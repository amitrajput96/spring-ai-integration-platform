package com.enterprise.ai.assistant;

import com.enterprise.ai.assistant.Service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAiAssistantApplicationTests
{

	@Test
	void contextLoads()
    {
	}

    @Autowired
    private ChatService chatService;

    @Test
    void testTemplateRender()
    {
        var output = this.chatService.chatTemplate();
        System.out.println(output);
    }

}
