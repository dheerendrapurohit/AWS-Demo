# AWS DEMO

This repository contains multiple Spring Boot demos showcasing integrations with **AWS services** and **Kafka**.

---

## 1. AWS Step Functions Demo (Spring Boot + Java)

This project demonstrates how to integrate **AWS Step Functions** with a Spring Boot application using the AWS SDK v2.  
It contains a simple service and REST API that can start a Step Function state machine execution.

---

## 2. AWS SNS Spring Boot Demo

This is a simple Spring Boot application that demonstrates how to publish messages to an **AWS SNS (Simple Notification Service)** topic using the AWS SDK v2.  
The application provides a REST endpoint to send messages to a configured SNS topic.

---

## 3. AWS SQS Demo with Spring Boot

This project demonstrates how to integrate **Amazon SQS (Simple Queue Service)** with a Spring Boot application using the AWS SDK v2.

### ✨ Features
- Send messages to an SQS queue  
- Receive messages from the queue  
- Simple REST endpoints to test  

---

## 4. AWS Kinesis Event Streaming with Spring Boot

This project demonstrates how to use **Spring Boot** with the **AWS SDK v2** to produce and consume events using **Amazon Kinesis Data Streams**.

---

## 5. Spring Boot Kafka Example

This project demonstrates a simple **Spring Boot + Apache Kafka** integration.  
It includes a Kafka **producer** that sends messages to a topic, and a Kafka **consumer** that listens for those messages.

### How to Run

  #### 1. Start Zookeeper (classic mode)
  .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
  
  #### 2.### Start Kafka Broker
  .\bin\windows\kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1 
  
  #### 3. Run the Spring Boot Application 
  
  #### 4. Send a Message
  http://localhost:8080/kafka/send/helloKafka
