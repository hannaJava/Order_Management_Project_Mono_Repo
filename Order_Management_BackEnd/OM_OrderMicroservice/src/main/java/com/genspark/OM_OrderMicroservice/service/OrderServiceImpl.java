package com.genspark.OM_OrderMicroservice.service;

import com.genspark.OM_OrderMicroservice.exception.RecordNotFoundException;
import com.genspark.OM_OrderMicroservice.model.Customer;
import com.genspark.OM_OrderMicroservice.model.Order;
import com.genspark.OM_OrderMicroservice.model.OrderObjectsWrapper;
import com.genspark.OM_OrderMicroservice.model.Product;
import com.genspark.OM_OrderMicroservice.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class OrderServiceImpl implements OrderServiceInt{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private static final String ORDER_SERVICE="order_circuit_breaker";

    @Override
    //@CircuitBreaker(name=ORDER_SERVICE,fallbackMethod = "OrderServiceFallback")
    public Order saveOrder(Order order) {
        String orderStatus="created";
        //restTemplate.postForEntity();//publish message to broker with created status
        restTemplate.postForEntity("http://EVENT-PRODUCER-SERVICE/order_manage/order_events/publish/"+orderStatus,
                order,Order.class);
        //restTemplate.postForEntity();//update product qte
        //Product product=restTemplate.getForObject("http://PRODUCT-SERVICE/order_manage/products/"+order.getProductId(),Product.class);
        //if(product.getQte()-order.getQte()>=0)
           // {   int qte= product.getQte()-order.getQte();
               // product.setQte(qte);}
        //restTemplate.postForEntity("http://PRODUCT-SERVICE/order_manage/products/"+product.getId(),product,Product.class);
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
    @CircuitBreaker(name=ORDER_SERVICE,fallbackMethod = "OrderServiceFallback")
    //@Retry(name=ORDER_SERVICE,fallbackMethod ="fallback_retry")
    public OrderObjectsWrapper getOrderCustomerProduct(long id) {
        Order order=orderRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no order exist with id: "+id));
        System.out.println(order.toString());
        Product product=restTemplate.getForObject("http://PRODUCT-SERVICE/order_manage/products/"+order.getProductId(),Product.class);
        Customer customer=restTemplate.getForObject("http://CUSTOMER-SERVICE/order_manage/customers/id/"+order.getCustomerId(),Customer.class);
        OrderObjectsWrapper orderObjectsWrapper=new OrderObjectsWrapper();
        orderObjectsWrapper.setOrder(order);
        orderObjectsWrapper.setProduct(product);
        orderObjectsWrapper.setCustomer(customer);
        return orderObjectsWrapper;
    }
    public  OrderObjectsWrapper OrderServiceFallback(Exception exception){
        System.out.println(" order service is not available...");
        return null;
    }

    @Override
   // @CircuitBreaker(name=ORDER_SERVICE,fallbackMethod = "OrderServiceFallback")
    public Order deleteOrder(long id) {
        Order order=orderRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no order exist with id: "+id));
        // if( order==null) return;
        String status="cancelled";
        String customerEmailId="";//Customer customer=restTemplate.getForObject("http://CUSTOMER-SERVICE/order_manage/customers/"+order.getCustomerId(),Customer.class).getEmailId;
        //restTemplate.postForEntity();//publish message to broker with cancelled status
        //restTemplate.postForEntity();//update product qte
       /* Product product=restTemplate.getForObject("http://PRODUCT-SERVICE/order_manage/products/"+order.getProductId(),Product.class);
        int qte= product.getQte()+order.getQte();
            product.setQte(qte);
        restTemplate.postForEntity("http://PRODUCT-SERVICE/order_manage/products/"+product.getId(),product,Product.class);
        */orderRepository.deleteById(id);
        return order;
    }

    @Override
   // @CircuitBreaker(name=ORDER_SERVICE,fallbackMethod = "OrderServiceFallback")
    public Order updateOrder(long id,Order order) {
        Order optional=orderRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no order exist with id: "+id));
        optional.setQte(order.getQte());
        //restTemplate.postForEntity();//update product qte
        return orderRepository.save(optional);
    }
}
