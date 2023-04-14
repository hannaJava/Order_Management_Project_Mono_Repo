package com.genspark.OM_OrderMicroservice.servicetest;

import com.genspark.OM_OrderMicroservice.model.Order;
import com.genspark.OM_OrderMicroservice.repository.OrderRepository;
import com.genspark.OM_OrderMicroservice.service.OrderServiceInt;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Autowired
    OrderServiceInt orderService;
    @MockBean
    private OrderRepository orderRepository;
    @Test
    public void getOrderByIdTest(){
        long id=2;
        Order expected=new Order(2L,2L,2L,1,null);
        Mockito.when(orderRepository.findById(id)).thenReturn(Optional.of(expected));
        Order actual=orderService.getOrderById(id);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void saveOrderTest(){
        Order expected=new Order(2L,2L,2L,1,null);
        Mockito.when(orderRepository.save(expected)).thenReturn(expected);
        Order actual=orderService.saveOrder(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateOrderTest(){
        long id=2;
        Order expected=new Order(2L,2L,2L,1,null);
        Mockito.when(orderRepository.findById(id)).thenReturn(Optional.of(expected));
        Mockito.when(orderRepository.save(expected)).thenReturn(expected);
        Order actual=orderService.updateOrder(id,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteOrderTest(){
        long id=2;
        Order expected=new Order(2L,2L,2L,1,null);
        Mockito.when(orderRepository.findById(id)).thenReturn(Optional.of(expected));
        Order actual=orderService.deleteOrder(id);
        Assert.assertEquals(expected,actual);
    }
}
