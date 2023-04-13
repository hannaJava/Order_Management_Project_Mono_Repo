package com.genspark.OM_ProductMicroservice.servicetest;

import com.genspark.OM_ProductMicroservice.model.Product;
import com.genspark.OM_ProductMicroservice.repository.ProductRepository;
import com.genspark.OM_ProductMicroservice.service.ProductServiceInt;
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
public class ProductServiceTest {
    @Autowired
    ProductServiceInt productService;
    @MockBean
    private ProductRepository productRepository;
    @Test
    public void getProductByIdTest(){
        long id=2;
        Product expected=new Product(2,"phone","mobile",1000,1);
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(expected));
        Product actual=productService.getProductById(id);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void saveProductTest(){
        Product expected=new Product(2,"phone","mobile",1000,1);
        Mockito.when(productRepository.save(expected)).thenReturn(expected);
        Product actual=productService.saveProduct(expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateProductTest(){
        long id=2;
        Product expected=new Product(2,"phone","mobile",1000,1);
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(expected));
        Mockito.when(productRepository.save(expected)).thenReturn(expected);
        Product actual=productService.updateProduct(id,expected);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void deleteProductTest(){
        long id=2;
        Product expected=new Product(2,"phone","mobile",1000,1);
        Mockito.when(productRepository.findById(id)).thenReturn(Optional.of(expected));
        Product actual=productService.deleteProduct(id);
        Assert.assertEquals(expected,actual);
    }
}
