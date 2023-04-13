package com.genspark.OM_KafkaProducerMicroservice.config;

import com.genspark.OM_KafkaProducerMicroservice.model.OrderEvent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaProducerConfig {

    /*@Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;*/
    @Bean
    public ProducerFactory<String, OrderEvent> producerFactory(){
        Map<String,Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer .class);
        return new DefaultKafkaProducerFactory(props);
    }

    @Bean
    public KafkaTemplate<String,OrderEvent> kafkaTemplate(){

        return new KafkaTemplate<>(producerFactory());
    }
}
