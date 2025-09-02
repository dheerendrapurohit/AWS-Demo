package com.example.awsdemo.sns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@RestController
@RequestMapping("/sns")
public class SnsController {

    private static final Logger log = LoggerFactory.getLogger(SnsController.class);
    private final SnsClient snsClient;

    public SnsController(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    @GetMapping("/send-sns")
    public String sendMessage(@RequestParam String message,
                              @RequestParam String topicArn) {

        PublishRequest request = PublishRequest.builder()
                .message(message)
                .topicArn(topicArn)
                .build();

        PublishResponse response = snsClient.publish(request);

        // Log SNS response details
        log.info("SNS MessageId: {}", response.messageId());
        log.info("SNS Response Metadata: {}", response.responseMetadata());

        return "Message sent! MessageId = " + response.messageId();
    }
}
