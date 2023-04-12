package com.genspark.OM_ProductMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="product_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="product_id")
    private long id;
    @Column(name="product_description")
    private String description;
    @Column(name="product_name")
    private String name;
    @Column(name="product_unit_price")
    private double unitPrice;
    @Column(name="product_qte")
    private int qte;
}
