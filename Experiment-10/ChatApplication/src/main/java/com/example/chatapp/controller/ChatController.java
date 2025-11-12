package com.example.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.example.chatapp.model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")       // listens to /app/sendMessage
    @SendTo("/topic/public")              // broadcasts to all subscribers
    public ChatMessage sendMessage(ChatMessage message) {
        return message; // echo back to everyone
    }
}
