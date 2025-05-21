package com.mobisoftinfotech.kafkaexample.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobisoftinfotech.kafkaexample.services.MessageProducerService;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {

    private final MessageProducerService messageProducerService;

    public MessageController(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        messageProducerService.sendMessage("test-topic", message);
        return ResponseEntity.ok("Message sent successfully");
    }

}
