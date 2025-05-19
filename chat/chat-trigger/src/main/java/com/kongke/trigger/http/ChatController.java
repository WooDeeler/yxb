package com.kongke.trigger.http;

import com.kongke.domain.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 聊天接口
 *
 * @author kongke
 * @date 2025/05/19
 */
@RequestMapping("/chat")
@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

}
