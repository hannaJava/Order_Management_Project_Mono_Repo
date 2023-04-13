package com.genspark.OM_CustomerMicroservice.servicetest;

import com.genspark.OM_CustomerMicroservice.model.Customer;
import com.genspark.OM_CustomerMicroservice.repository.CustomerRepository;
import com.genspark.OM_CustomerMicroservice.service.CustomerServiceInt;
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
public class CustomerServiceTest {
    @Autowired
    CustomerServiceInt customerService;
    @MockBean
    private CustomerRepository customerRepository;
    @Test
    public void getCustomerByIdTest(){
        long id=2;
        Customer expected=new Customer(2,"username","password",
                "address","1234567889","email@domain.com");
        Mockito.when(customerRepository.findById(id)).thenReturn(Optional.of(expected));
        Customer actual=customerService.getCustomerById(id);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void saveCustomerTest(){
        Customer expected=new Customer(2,"username","password",
                "address","1234567889","email@domain.com");
        Mockito.when(customerRepository.save(expected)).thenReturn(expected);
        Customer actual=customerService.saveCustomer(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateCustomerTest(){
        long id=2;
        Customer expected=new Customer(2,"username","password",
                "address","1234567889","email@domain.com");
        Mockito.when(customerRepository.findById(id)).thenReturn(Optional.of(expected));
        Mockito.when(customerRepository.save(expected)).thenReturn(expected);
        Customer actual=customerService.updateCustomer(id,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteCustomerTest(){
        long id=2;
        Customer expected=new Customer(2,"username","password",
                "address","1234567889","email@domain.com");
        Mockito.when(customerRepository.findById(id)).thenReturn(Optional.of(expected));
        Customer actual=customerService.deleteCustomer(id);
        Assert.assertEquals(expected,actual);
    }
}
