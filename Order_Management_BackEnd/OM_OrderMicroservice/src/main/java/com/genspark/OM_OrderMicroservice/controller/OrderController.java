package com.genspark.OM_OrderMicroservice.controller;

import com.genspark.OM_OrderMicroservice.model.Order;
import com.genspark.OM_OrderMicroservice.service.OrderServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_manage/orders")
public class OrderController {

    @Autowired
    OrderServiceInt orderService;
    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") long id){
        return orderService.getOrderById(id);
    }
    /*@PostMapping("/add")
    public Order saveOrder(@RequestBody Order Order){
        OrderService.saveOrder(Order);
        return OrderService.getOrderById(Order.getId());
    }*/
    @PostMapping("/")
    public long addOrder(@RequestBody Order Order) {
        orderService.saveOrder(Order);
        return orderService.getOrderById(Order.getId()).getId();
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") long id,@RequestBody Order Order){
        orderService.updateOrder(id,Order);
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable("id") long id){

        return orderService.deleteOrder(id);
    }
}
