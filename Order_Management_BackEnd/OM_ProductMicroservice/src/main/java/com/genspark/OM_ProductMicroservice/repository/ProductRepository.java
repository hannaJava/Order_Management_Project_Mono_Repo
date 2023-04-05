package com.genspark.OM_ProductMicroservice.repository;

import com.genspark.OM_ProductMicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
