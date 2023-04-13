//package com.genspark.OM_KafkaConsumerMicroservice.controller;
//
//import com.genspark.OM_KafkaConsumerMicroservice.service.EmailServiceConsumer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/order_manage")
//public class MailController {
//    @Autowired
//    EmailServiceConsumer emailServiceConsumer;
//    @PostMapping("/sendmail/{email}")
//    public void sendEmail(@PathVariable("email") String email){
//        emailServiceConsumer.sendEmail(email);
//    }
//
//}
