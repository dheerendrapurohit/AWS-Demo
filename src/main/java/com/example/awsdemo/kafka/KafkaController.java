package com.example.awsdemo.kafka;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/send/{msg}")
    public String sendMessage(@PathVariable String msg) {
        producerService.sendMessage(msg);
        return "Message sent: " + msg;
    }
}
