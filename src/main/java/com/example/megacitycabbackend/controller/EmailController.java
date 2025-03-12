package com.example.megacitycabbackend.controller;


import com.example.megacitycabbackend.dto.EmailDto;
import com.example.megacitycabbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @GetMapping("/sendemail")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        try {
            return emailService.sendEmail(to, subject, body);
        } catch (IOException e) {
            return "Error sending email: " + e.getMessage();
        }
    }

}
