package com.example.awsdemo.sqs;

import com.example.awsdemo.sqs.SqsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class SqsController {

    private final SqsService sqsService;

    public SqsController(SqsService sqsService) {
        this.sqsService = sqsService;
    }

    @PostMapping("/send")
    public String send(@RequestParam String message) {
        sqsService.sendMessage(message);
        return "Message sent: " + message;
    }

    @GetMapping("/receive")
    public String receive() {
        sqsService.receiveMessages();
        return "Messages received (check logs).";
    }
}
