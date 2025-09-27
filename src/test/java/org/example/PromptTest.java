package org.example;

import org.example.assistant.MemoryChatAssistant;
import org.example.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {
    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(3, "今天几号");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testUserMessage() {
        String answer = memoryChatAssistant.chat("我是张三");
        System.out.println(answer);

        String answer2 = memoryChatAssistant.chat("我18岁");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer3);
    }
}
