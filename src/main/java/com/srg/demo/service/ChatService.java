package com.srg.demo.service;


import com.srg.demo.entity.ChatMessage;
import com.srg.demo.repository.ChatMessageRepository;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final ChatMessageRepository chatMessageRepository;

    public ChatService(
            ChatClient.Builder chatClientBuilder,
            ChatMessageRepository chatMessageRepository) {

        this.chatClient = chatClientBuilder.build();
        this.chatMessageRepository = chatMessageRepository;
    }

    public String getResponse(String message) {

//         Send user question to Llama 3.2
//        String response = chatClient
//                .prompt()
//                .user(message)
//                .call()
//                .content();
    	String response = "Test response from Render";

       

        // Save question and response into database
        ChatMessage chatMessage = new ChatMessage(
                message,
                response,
                LocalDateTime.now()
        );

        chatMessageRepository.save(chatMessage);

        return response;
    }
}