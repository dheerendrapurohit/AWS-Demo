package com.example.awsdemo.stepfunction;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stepfunction")
public class StepFunctionController {

    private final StepFunctionService stepFunctionService;

    public StepFunctionController(StepFunctionService stepFunctionService) {
        this.stepFunctionService = stepFunctionService;
    }

    @PostMapping("/start")
    public String startExecution(
            @RequestParam String stateMachineArn,
            @RequestBody String inputJson) {
        return stepFunctionService.startExecution(stateMachineArn, inputJson);
    }
}
