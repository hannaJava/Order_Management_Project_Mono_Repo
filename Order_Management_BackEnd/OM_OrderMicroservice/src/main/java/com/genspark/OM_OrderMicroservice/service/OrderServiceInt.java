package com.genspark.OM_OrderMicroservice.service;

import com.genspark.OM_OrderMicroservice.model.Order;
import com.genspark.OM_OrderMicroservice.model.OrderObjectsWrapper;

import java.util.List;

public interface OrderServiceInt {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    OrderObjectsWrapper getOrderCustomerProduct(Long id);
    Order deleteOrder(Long id);

    Order updateOrder(Long id,Order order);
}
