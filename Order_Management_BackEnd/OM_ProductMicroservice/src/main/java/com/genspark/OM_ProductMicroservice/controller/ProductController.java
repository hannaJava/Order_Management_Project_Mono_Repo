package com.genspark.OM_ProductMicroservice.controller;

import com.genspark.OM_ProductMicroservice.model.Product;
import com.genspark.OM_ProductMicroservice.service.ProductServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/order_manage/products")
public class ProductController {

    @Autowired
    ProductServiceInt productService;
    @GetMapping("/")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id){

        return productService.getProductById(id);
    }
    @PostMapping("/")
    public long addProduct(@RequestBody Product Product) {
        productService.saveProduct(Product);
        return productService.getProductById(Product.getId()).getId();
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id,@RequestBody Product Product){
        return productService.updateProduct(id,Product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") long id){

        return productService.deleteProduct(id);
    }
}
