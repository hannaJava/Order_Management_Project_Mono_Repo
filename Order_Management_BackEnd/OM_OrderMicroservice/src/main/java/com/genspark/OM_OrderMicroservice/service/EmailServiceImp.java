package com.genspark.OM_OrderMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp {

    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String to){
        SimpleMailMessage message=new SimpleMailMessage();
        String subject="Order has been placed";
        String body=" testing email";
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
