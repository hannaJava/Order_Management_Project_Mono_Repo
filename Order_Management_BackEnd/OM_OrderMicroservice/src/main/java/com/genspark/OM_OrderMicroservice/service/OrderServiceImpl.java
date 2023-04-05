package com.genspark.OM_OrderMicroservice.service;

import com.genspark.OM_OrderMicroservice.exception.RecordNotFoundException;
import com.genspark.OM_OrderMicroservice.model.Customer;
import com.genspark.OM_OrderMicroservice.model.Order;
import com.genspark.OM_OrderMicroservice.model.OrderObjectsWrapper;
import com.genspark.OM_OrderMicroservice.model.Product;
import com.genspark.OM_OrderMicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class OrderServiceImpl implements OrderServiceInt{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

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
    public OrderObjectsWrapper getOrderCustomerProduct(long id) {
        Order order=orderRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no order exist with id: "+id));
        Product product=restTemplate.getForObject("http://PRODUCT-SERVICE/order_manage/products/"+order.getProductId(),Product.class);
        Customer customer=restTemplate.getForObject("http://CUSTOMER-SERVICE/order_manage/customers/"+order.getCustomerId(),Customer.class);
        OrderObjectsWrapper orderObjectsWrapper=new OrderObjectsWrapper();
        orderObjectsWrapper.setOrder(order);
        orderObjectsWrapper.setProduct(product);
        orderObjectsWrapper.setCustomer(customer);
        return orderObjectsWrapper;
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
