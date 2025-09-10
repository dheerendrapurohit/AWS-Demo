AWS & Messaging Demos (Spring Boot + Java)

This repository contains multiple demo projects that show how to integrate Spring Boot applications with various AWS services and messaging platforms. Each demo is implemented using the AWS SDK v2 or respective provider SDKs.


1. AWS Step Functions Demo (Spring Boot + Java)

This project demonstrates how to integrate AWS Step Functions with a Spring Boot application.
It contains a simple service and REST API to start a Step Function state machine execution.
This class is a minimal “Hello World” for AWS Step Functions in Java. It connects to AWS, starts a Step Function execution with input, and prints the execution ARN so you can track it.

2. AWS SNS (Simple Notification Service) Demo

This is a simple Spring Boot application that demonstrates how to publish messages to an SNS topic using the AWS SDK v2.
It provides a REST endpoint to send messages to a configured SNS topic.
In this example, the Spring Boot app acts as the publisher, and an email subscription will receive the messages.

3. AWS SQS (Simple Queue Service) Demo

This project shows how to integrate Amazon SQS with Spring Boot.

In this exampke it lets you:

  Send messages (producer)
  
  Store messages (queue)
  
  Receive messages (consumer)

4. AWS Kinesis Event Streaming Demo

This project demonstrates how to use Spring Boot with the AWS SDK v2 to produce and consume events using Amazon Kinesis Data Streams.

In this example we used,

  A Producer (Spring Boot REST API) to publish events into a Kinesis stream.
  
  A Consumer (Spring Boot service) to continuously read those events from the stream.

5. AWS ElastiCache (Redis) Demo

This project shows how to connect a Spring Boot application with AWS ElastiCache Redis (Cluster Mode Enabled).

6. Twilio SMS Demo (Spring Boot)

This is a simple Spring Boot application that demonstrates how to send SMS messages using Twilio.

7. SendGrid Email Demo (Spring Boot)

This project demonstrates how to send emails using SendGrid in a Spring Boot application.

Features:

REST API endpoint to send an email

Uses SendGrid Java SDK

Configuration via application.properties

⚙️ Prerequisites

Java 17+

Maven

AWS CLI configured with valid credentials (aws configure)

AWS account with required services enabled

Twilio & SendGrid accounts with valid API keys
