package com.genspark.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerImpl implements KafkaProducerInt {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private final static String TOPIC_NAME = "orderActivityTopic";

	public void sendMessage(String orderActivity)
	{
		kafkaTemplate.send(TOPIC_NAME, orderActivity);
	}
}
