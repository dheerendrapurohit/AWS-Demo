package com.example.awsdemo.sendgrid;

import com.example.awsdemo.sendgrid.EmailService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String subject,
                            @RequestParam String body) throws IOException {
        return emailService.sendEmail(to, subject, body);
    }
}
