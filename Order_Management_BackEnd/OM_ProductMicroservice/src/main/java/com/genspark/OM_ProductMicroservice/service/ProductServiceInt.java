package com.genspark.OM_ProductMicroservice.service;

import com.genspark.OM_ProductMicroservice.model.Product;

import java.util.List;

public interface ProductServiceInt {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product deleteProduct(long id);

    void updateProduct(long id,Product product);
}
