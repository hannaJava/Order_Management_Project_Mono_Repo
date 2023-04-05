package com.genspark.OM_OrderMicroservice.service;

import com.genspark.OM_OrderMicroservice.exception.RecordNotFoundException;
import com.genspark.OM_OrderMicroservice.model.Order;
import com.genspark.OM_OrderMicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class OrderServiceImpl implements OrderServiceInt{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no order exist with id: "+id));
    }

    @Override
    public Order deleteOrder(long id) {
        Order order=orderRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no order exist with id: "+id));
        // if( order==null) return;
        orderRepository.deleteById(id);
        return order;
    }

    @Override
    public void updateOrder(long id,Order order) {
        Order optional=orderRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no order exist with id: "+id));
        //Optional<order> optional=orderRepository.findById(id);
        Order ord;
        //if(optional.isPresent()){
        ord=optional;//.get();
       // dep.setorderLocation(order.getorderLocation());
       // dep.setorderName(order.getorderName());
        orderRepository.save(ord);
        // }
    }
}
