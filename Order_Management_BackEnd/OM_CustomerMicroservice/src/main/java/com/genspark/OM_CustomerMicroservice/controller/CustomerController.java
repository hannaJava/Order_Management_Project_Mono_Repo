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
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") long id){
        return customerService.getCustomerById(id);
    }

    @GetMapping("/{username}")
    public Long getCustomerById(@PathVariable("username") String username){
        return customerService.getCustomerByUsername(username).getId();
    }
    /*@PostMapping("/add")
    public Customer saveCustomer(@RequestBody Customer Customer){
        CustomerService.saveCustomer(Customer);
        return CustomerService.getCustomerById(Customer.getId());
    }*/
    @PostMapping("/")
    public long saveCustomer(@RequestBody Customer Customer) {
        customerService.saveCustomer(Customer);
        return customerService.getCustomerById(Customer.getId()).getId();
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") long id,@RequestBody Customer Customer){
        customerService.updateCustomer(id,Customer);
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable("id") long id){

        return customerService.deleteCustomer(id);
    }
}
