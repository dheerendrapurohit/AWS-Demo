package com.example.awsdemo.sqs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

@Service
public class SqsService {

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queue.url}")
    private String queueUrl;

    public SqsService(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    // Send a message
    public void sendMessage(String message) {
        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build();

        sqsClient.sendMessage(request);
        System.out.println("Message sent: " + message);
    }

    // Receive messages
    public void receiveMessages() {
        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(5)
                .waitTimeSeconds(5)
                .build();

        sqsClient.receiveMessage(request).messages().forEach(msg -> {
            System.out.println("Message received: " + msg.body());

            // Delete after processing
            sqsClient.deleteMessage(DeleteMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .receiptHandle(msg.receiptHandle())
                    .build());
        });
    }
}
