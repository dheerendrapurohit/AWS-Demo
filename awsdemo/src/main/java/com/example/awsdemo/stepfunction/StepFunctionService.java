package com.example.awsdemo.stepfunction;

public interface StepFunctionService {
    String startExecution(String stateMachineArn, String inputJson);
}
