package com.genspark.OM_CustomerMicroservice.service;

import com.genspark.OM_CustomerMicroservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerServiceInt {
    Customer saveCustomer(Customer Customer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(long id);
   // List<Customer> getCustomerByAddress(String address);

    Customer deleteCustomer(long id);

    Customer updateCustomer(long id,Customer Customer);

    Customer getCustomerByUsername(String username);
}
