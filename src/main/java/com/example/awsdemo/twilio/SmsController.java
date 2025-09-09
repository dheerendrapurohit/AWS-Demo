package com.example.awsdemo.twilio;

import com.example.awsdemo.twilio.SmsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public String sendSms(@RequestParam String to, @RequestParam String body) {
        return "Message Sent! SID: " + smsService.sendSms(to, body);
    }
}
