package com.example.awsdemo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("my-topic", message);
        System.out.println("Sent: " + message);
    }
}
