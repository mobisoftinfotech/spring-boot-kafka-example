package com.mobisoftinfotech.kafkaexample.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {


    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void consumeMessageLister(String message) {
        System.out.println("Message received: " + message);
    }
}
