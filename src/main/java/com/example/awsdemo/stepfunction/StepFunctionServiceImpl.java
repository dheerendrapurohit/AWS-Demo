package com.example.awsdemo.stepfunction;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sfn.SfnClient;
import software.amazon.awssdk.services.sfn.model.StartExecutionRequest;
import software.amazon.awssdk.services.sfn.model.StartExecutionResponse;

@Service
public class StepFunctionServiceImpl implements StepFunctionService {

    private final SfnClient sfnClient;

    public StepFunctionServiceImpl() {
        this.sfnClient = SfnClient.create();
    }

    @Override
    public String startExecution(String stateMachineArn, String inputJson) {
        StartExecutionRequest request = StartExecutionRequest.builder()
                .stateMachineArn(stateMachineArn)
                .name("execution-" + System.currentTimeMillis())
                .input(inputJson)
                .build();

        StartExecutionResponse response = sfnClient.startExecution(request);
        return response.executionArn();
    }
}
