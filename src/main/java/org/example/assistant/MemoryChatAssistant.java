package org.example.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT, //explicit: 使用显式配置，而不是自动配置
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {
//    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{it}}") //{{it}}表示这里唯一的参数的占位符
//    String chat(String message);

    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{message}}") //{{it}}表示这里唯一的参数的占位符
    String chat(@V("message") String message);
}
