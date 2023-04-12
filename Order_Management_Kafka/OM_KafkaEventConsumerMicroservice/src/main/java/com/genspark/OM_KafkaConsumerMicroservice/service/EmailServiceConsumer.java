package com.genspark.OM_KafkaConsumerMicroservice.service;

import com.genspark.OM_KafkaConsumerMicroservice.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceConsumer {

    public static final Logger LOGGER= LoggerFactory.getLogger(EmailServiceConsumer.class);

    @Autowired
    private JavaMailSender mailSender;
    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group_id}")
    public void consume(OrderEvent orderEvent){
        LOGGER.info(String.format("order event ->%s",orderEvent.toString()));
        LOGGER.info(String.format("order event ->%s",orderEvent.getStatus().toString()));
        //send email
        String subject="Order has been "+orderEvent.getStatus();
        String body="";
        sendEmail(orderEvent.getCustomerEmailId(),subject, body);
    }

    public void sendEmail(String to,String subject,String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
