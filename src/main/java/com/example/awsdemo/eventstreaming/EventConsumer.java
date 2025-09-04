package com.example.awsdemo.eventstreaming;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.kinesis.*;
import software.amazon.awssdk.services.kinesis.model.*;

@Component
public class EventConsumer implements CommandLineRunner {

    private final String streamName;
    private final String region;

    public EventConsumer(@Value("${aws.kinesis.streamName}") String streamName,
                         @Value("${aws.region}") String region) {
        this.streamName = streamName;
        this.region = region;
    }

    @Override
    public void run(String... args) {
        try (KinesisClient kinesisClient = KinesisClient.builder()
                .region(software.amazon.awssdk.regions.Region.of(region))
                .build()) {

            String shardId = kinesisClient.describeStream(
                    DescribeStreamRequest.builder().streamName(streamName).build()
            ).streamDescription().shards().get(0).shardId();

            GetShardIteratorRequest iteratorRequest = GetShardIteratorRequest.builder()
                    .streamName(streamName)
                    .shardId(shardId)
                    .shardIteratorType(ShardIteratorType.TRIM_HORIZON)
                    .build();

            String shardIterator = kinesisClient.getShardIterator(iteratorRequest).shardIterator();

            while (true) {
                GetRecordsResponse recordsResponse = kinesisClient.getRecords(
                        GetRecordsRequest.builder().shardIterator(shardIterator).limit(5).build()
                );

                recordsResponse.records().forEach(record ->
                        System.out.println("✅ Consumed Event: " + record.data().asUtf8String())
                );

                shardIterator = recordsResponse.nextShardIterator();

                Thread.sleep(2000);
            }

        } catch (Exception e) {
            System.err.println("⚠️ Failed to start EventConsumer: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
