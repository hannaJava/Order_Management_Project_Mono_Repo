package com.genspark.kafkaproducer.controller;

import com.genspark.kafkaproducer.service.KafkaProducerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/order_manage/order_activities")//, produces="text/plain")
public class KafkaMessageController
{
   
    @Autowired
	private KafkaProducerImpl kafkaProducerImpl;
 
    /*@PostMapping("/publish/{hrEvent}")
    public String publishMessage(@PathVariable("hrEvent")final String hrEvent)
    {
    	kafkaProducerImpl.sendMessage(hrEvent);
		System.out.println("Successfully Published the HR event = '" + hrEvent + "' to the HrEventTopic");
		return "Successfully Published the HR event  = " + hrEvent + " to the HrEventTopic";
    }*/

    @PostMapping("/publish")
    public String publishMessage(@RequestBody String orderActivity)
    {
        System.out.println("order activity message = '" + orderActivity + "' published to the orderActivityTopic");
        kafkaProducerImpl.sendMessage(orderActivity);
        return "Order activity message = '" + orderActivity + "' published to the orderActivityTopic";
    }
}
