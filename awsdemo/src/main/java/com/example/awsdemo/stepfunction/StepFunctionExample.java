package com.example.awsdemo.stepfunction;

import software.amazon.awssdk.services.sfn.SfnClient;
import software.amazon.awssdk.services.sfn.model.StartExecutionRequest;
import software.amazon.awssdk.services.sfn.model.StartExecutionResponse;

public class StepFunctionExample {
    public static void main(String[] args) {
        try (SfnClient sfnClient = SfnClient.create()) {
            StartExecutionRequest request = StartExecutionRequest.builder()
                    .stateMachineArn("arn:aws:states:ap-south-1:865653019855:execution:HelloWorldStateMachine")

                    .input("{\"key\":\"value\"}")
                    .build();

            StartExecutionResponse response = sfnClient.startExecution(request);
            System.out.println("Execution started with ARN: " + response.executionArn());
        }
    }
}
