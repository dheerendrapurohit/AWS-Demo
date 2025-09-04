package com.example.awsdemo.eventstreaming;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;

@RestController
@RequestMapping("/events")
public class EventProducer {

    private KinesisClient kinesisClient;
    private final String streamName;
    private final String region;

    public EventProducer(@Value("${aws.kinesis.streamName}") String streamName,
                         @Value("${aws.region}") String region) {
        this.streamName = streamName;
        this.region = region;
    }

    @PostConstruct
    public void init() {
        this.kinesisClient = KinesisClient.builder()
                .region(software.amazon.awssdk.regions.Region.of(region))
                .build();
    }

    @PostMapping("/publish")
    public String publish(@RequestParam String message) {
        PutRecordRequest request = PutRecordRequest.builder()
                .streamName(streamName)
                .partitionKey("partitionKey")
                .data(SdkBytes.fromByteArray(message.getBytes()))
                .build();

        kinesisClient.putRecord(request);
        return "Event published: " + message;
    }
}
