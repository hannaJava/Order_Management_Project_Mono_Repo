package com.genspark.OM_OrderMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="order_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private Long id;
    @Column(name="customer_id")
    private Long customerId;

    @Column(name="product_id")
    private Long productId;

    @Column(name="qte")
    private int qte;

    //@Column(name="gift")
   // @Lob
    //private byte[] gift;

   // public Order(byte[] gift){
   //     this.gift=gift;
   // }
}
