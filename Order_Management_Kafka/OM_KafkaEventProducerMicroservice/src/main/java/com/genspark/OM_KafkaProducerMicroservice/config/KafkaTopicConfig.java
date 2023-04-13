//package com.genspark.OM_KafkaProducerMicroservice.config;
//
//import com.genspark.OM_KafkaProducerMicroservice.model.OrderEvent;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.KafkaTemplate;
//
//@Configuration
//public class KafkaTopicConfig {
//
//    //to retrieve property value parse the property key in @Value annotation
//    @Value("${spring.kafka.topic.name}")
//    private String topicName;
//
//    @Bean
//    public NewTopic topic(){
//        return TopicBuilder.name(topicName)
//                .partitions(3)
//                .build();
//    }
//}
