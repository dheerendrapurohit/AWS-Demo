package com.example.awsdemo.kafka;

import com.example.awsdemo.eventstreaming.EventStreamingApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
    SpringApplication.run(KafkaApplication.class, args);
}
}
