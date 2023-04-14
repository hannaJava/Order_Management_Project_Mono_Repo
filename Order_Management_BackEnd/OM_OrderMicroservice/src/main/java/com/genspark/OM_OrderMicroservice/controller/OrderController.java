package com.genspark.OM_OrderMicroservice.controller;

import com.genspark.OM_OrderMicroservice.model.Order;
import com.genspark.OM_OrderMicroservice.model.OrderObjectsWrapper;
import com.genspark.OM_OrderMicroservice.service.EmailServiceImp;
import com.genspark.OM_OrderMicroservice.service.FileUploadServiceInt;
import com.genspark.OM_OrderMicroservice.service.OrderServiceInt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/order_manage/orders")
public class OrderController {

    @Autowired
    OrderServiceInt orderService;
    @Autowired
    FileUploadServiceInt fileUploadService;

    @Autowired
    EmailServiceImp emailService;
    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/cust_prod/{id}")
    public OrderObjectsWrapper getOrderCustomerProduct(@PathVariable("id") long id){

        /*OrderObjectsWrapper orderObjectsWrapper= orderService.getOrderCustomerProduct(id);
        ResponseEntity<OrderObjectsWrapper> responseEntity;
        if(orderObjectsWrapper==null) return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(orderObjectsWrapper);
        return new ResponseEntity<OrderObjectsWrapper>(orderService.getOrderCustomerProduct(id), HttpStatus.OK).getBody();*/
        return orderService.getOrderCustomerProduct(id);
    }

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order){//,@RequestParam("file") MultipartFile multipartFile) throws IOException {
        //order.setGift(multipartFile.getBytes());
        return orderService.saveOrder(order);
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") long id,@RequestBody Order order) {
        return orderService.updateOrder(id,order);
    }

    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable("id") long id){
        return orderService.deleteOrder(id);
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile multipartFile){    //which//@Annotation//to use?! @RequestPart
        System.out.println(" uploaded file with original name "+multipartFile.getOriginalFilename());
        fileUploadService.fileUpload(multipartFile);
    }

    @PostMapping("/sendmail/{email}")
    public void sendEmail(@PathVariable("email") String email){
        emailService.sendEmail(email);
    }
}
