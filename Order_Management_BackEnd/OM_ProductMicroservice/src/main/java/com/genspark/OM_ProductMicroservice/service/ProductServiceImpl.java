package com.genspark.OM_ProductMicroservice.service;

import com.genspark.OM_ProductMicroservice.exception.RecordNotFoundException;
import com.genspark.OM_ProductMicroservice.model.Product;
import com.genspark.OM_ProductMicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductServiceInt{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Product exist with id: "+id));
    }

    @Override
    public Product deleteProduct(long id) {
        Product product=productRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Product exist with id: "+id));
        // if( Product==null) return;
        productRepository.deleteById(id);
        return product;
    }

    @Override
    public Product updateProduct(long id,Product product) {
        Product optional=productRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("no Product exist with id: "+id));
        optional.setName(product.getName());
        optional.setDescription(product.getDescription());
        optional.setUnitPrice(product.getUnitPrice());
        optional.setQte(product.getQte());
        return productRepository.save(optional);
    }
}
