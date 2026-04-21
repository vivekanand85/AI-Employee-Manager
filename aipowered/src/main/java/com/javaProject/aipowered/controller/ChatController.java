package com.javaProject.aipowered.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaProject.aipowered.dto.AIResponseDTO;
import com.javaProject.aipowered.dto.ChatRequest;
import com.javaProject.aipowered.service.AiService;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {

	@Autowired
	AiService aiService;
	
	@PostMapping
	public AIResponseDTO chat(@RequestBody ChatRequest request) {
		String answer=aiService.getResponse(request.getQuestion());
		return new AIResponseDTO(answer);
	}
}

