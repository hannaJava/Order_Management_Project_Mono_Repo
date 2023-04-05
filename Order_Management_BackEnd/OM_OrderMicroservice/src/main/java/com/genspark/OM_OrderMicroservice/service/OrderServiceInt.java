package com.genspark.OM_OrderMicroservice.service;

import com.genspark.OM_OrderMicroservice.model.Order;

import java.util.List;

public interface OrderServiceInt {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(long id);
    Order deleteOrder(long id);

    void updateOrder(long id,Order order);
}
