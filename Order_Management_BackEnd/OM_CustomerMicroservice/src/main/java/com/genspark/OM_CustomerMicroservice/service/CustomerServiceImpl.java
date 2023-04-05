package com.genspark.OM_CustomerMicroservice.service;

import com.genspark.OM_CustomerMicroservice.exception.RecordNotFoundException;
import com.genspark.OM_CustomerMicroservice.model.Customer;
import com.genspark.OM_CustomerMicroservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class CustomerServiceImpl implements CustomerServiceInt{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Customer exist with id: "+id));
    }

    @Override
    public List<Customer> getCustomerByAddress(String address) {
        customerRepository.getByAddress();
        return customerRepository.getByAddress(address);
    }

    @Override
    public Customer deleteCustomer(long id) {
        Customer Customer=customerRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Customer exist with id: "+id));
        // if( Customer==null) return;
        customerRepository.deleteById(id);
        return Customer;
    }

    @Override
    public void updateCustomer(long id,Customer customer) {
        Customer optional=customerRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Customer exist with id: "+id));
        //Optional<Customer> optional=CustomerRepository.findById(id);
        Customer dep;
        //if(optional.isPresent()){
        dep=optional;//.get();
       // dep.setCustomerLocation(Customer.getCustomerLocation());
       // dep.setCustomerName(Customer.getCustomerName());
        customerRepository.save(dep);
        // }
    }
}
