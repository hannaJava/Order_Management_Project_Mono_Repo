package com.genspark.OM_OrderMicroservice.repository;

import com.genspark.OM_OrderMicroservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
