package com.genspark.OM_CustomerMicroservice.repository;

import com.genspark.OM_CustomerMicroservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
   // List<Customer> getByAddress(String address);

    Customer findByUsername(String username);
}
