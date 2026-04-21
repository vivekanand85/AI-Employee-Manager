package com.javaProject.aipowered.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tools.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.JsonNode; 

@Service
public class AiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ai.api.key}")
    private String apiKey;

    private final String URL = "https://api.openai.com/v1/chat/completions";

    public String getResponse(String question) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(apiKey); // Cleaner way to set "Bearer " + key
            headers.setContentType(MediaType.APPLICATION_JSON);

            // 1. Prepare the Prompt with Context
            String context = "Company policy: Employees get 20 days leave annually.";
            String fullPrompt = String.format("Context: %s\nUser Question: %s", context, question);

            // 2. Build Request Body as a Map (No more manual JSON string escaping!)
            Map<String, Object> body = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                    Map.of("role", "system", "content", "You are an HR assistant. Answer clearly."),
                    Map.of("role", "user", "content", fullPrompt)
                )
            );

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

            // 3. Make the call
            ResponseEntity<JsonNode> response = restTemplate.postForEntity(URL, request, JsonNode.class);

            // 4. Extract content using Path (Safe Navigation)
            return response.getBody()
                    .at("/choices/0/message/content")
                    .asText();

        } catch (Exception e) {
            e.printStackTrace(); // Always print the stack trace while debugging!
            return "AI service error: " + e.getMessage();
        }
    }
}