package com.genspark.OM_KafkaProducerMicroservice.controller;

import com.genspark.OM_KafkaProducerMicroservice.model.Order;
import com.genspark.OM_KafkaProducerMicroservice.model.OrderEvent;
import com.genspark.OM_KafkaProducerMicroservice.service.OrderEventKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order_manage/order_events")
public class OrderEventProducerController {
    @Autowired
    OrderEventKafkaProducer orderEventKafkaProducer;
    @PostMapping("/publish/{status}")
    public void publishOrderEvent(@PathVariable("status") String status,@RequestBody Order order){
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setStatus(status);//created or cancelled
        orderEvent.setMessage("an order has been "+status);
        orderEventKafkaProducer.sendMessage(orderEvent);
    }
}
