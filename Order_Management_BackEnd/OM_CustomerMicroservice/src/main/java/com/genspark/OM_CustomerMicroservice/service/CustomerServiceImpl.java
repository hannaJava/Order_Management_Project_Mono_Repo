package com.genspark.OM_CustomerMicroservice.service;

import com.genspark.OM_CustomerMicroservice.exception.RecordNotFoundException;
import com.genspark.OM_CustomerMicroservice.model.Customer;
import com.genspark.OM_CustomerMicroservice.repository.CustomerRepository;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServiceInt{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        String encryptedPassword=bcrypt.encode(customer.getPassword());
        customer.setPassword(encryptedPassword);
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

    /*@Override
    public List<Customer> getCustomerByAddress(String address) {
        customerRepository.getByAddress(address);
        return customerRepository.getByAddress(address);
    }*/

    @Override
    public Customer deleteCustomer(long id) {
        Customer Customer=customerRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Customer exist with id: "+id));
        // if( Customer==null) return;
        customerRepository.deleteById(id);
        return Customer;
    }

    @Override
    public Customer updateCustomer(long id,Customer customer) {
        Customer optional=customerRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Customer exist with id: "+id));
        optional.setUsername(customer.getUsername());
        optional.setPhone(customer.getPhone());
        optional.setAddress(customer.getAddress());
        optional.setEmail(customer.getEmail());
        return customerRepository.save(optional);
    }

    @Override
    public Customer getCustomerByUsername(String username) {

        return customerRepository.findByUsername(username);
    }
}
