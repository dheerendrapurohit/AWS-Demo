package com.example.awsdemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received: " + message);
    }
}
