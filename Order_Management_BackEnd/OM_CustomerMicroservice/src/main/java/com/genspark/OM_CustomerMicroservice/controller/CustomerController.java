package com.genspark.OM_CustomerMicroservice.controller;

import com.genspark.OM_CustomerMicroservice.model.Customer;
import com.genspark.OM_CustomerMicroservice.service.CustomerServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/order_manage/customers")
public class CustomerController {

    @Autowired
    CustomerServiceInt customerService;
    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/id/{id}")
    public Customer getCustomerById(@PathVariable("id") long id){

        return customerService.getCustomerById(id);
    }

    @GetMapping("/username/{username}")
    public Customer getCustomerByUsername(@PathVariable("username") String username){
        return customerService.getCustomerByUsername(username);
    }
    @PostMapping("/")
    public long saveCustomer(@RequestBody Customer Customer) {
        customerService.saveCustomer(Customer);
        return customerService.getCustomerById(Customer.getId()).getId();
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") long id,@RequestBody Customer Customer){
        return customerService.updateCustomer(id,Customer);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable("id") long id){

        return customerService.deleteCustomer(id);
    }
}
