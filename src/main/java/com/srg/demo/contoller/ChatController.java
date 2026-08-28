package com.srg.demo.contoller;

import com.srg.demo.dto.ChatRequest;
import com.srg.demo.dto.ChatResponse;
import com.srg.demo.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {
	@Autowired
	ChatService chatService;

	@GetMapping("/health")
	public String health() {
		return "Chat API is running";
	}

	@PostMapping
	public ChatResponse chat(@RequestBody ChatRequest request) {

		String response = chatService.getResponse(request.getMessage());

		return new ChatResponse(request.getMessage(), response);
	}
}