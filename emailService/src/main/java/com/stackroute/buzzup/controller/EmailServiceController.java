package com.stackroute.buzzup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.service.EmailNotificationService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailServiceController {

    private EmailNotificationService emailNotificationService;
    
    @Autowired
    public EmailServiceController(EmailNotificationService emailNotificationService) {
        super();
        this.emailNotificationService = emailNotificationService;
    }
}