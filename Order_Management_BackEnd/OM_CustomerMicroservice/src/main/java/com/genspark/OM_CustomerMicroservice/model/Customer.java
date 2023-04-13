package com.genspark.OM_CustomerMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="customer_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private long id;
    @Column(name="customer_username")
    private String username;
    @Column(name="customer_password")
    private String password;
    @Column(name="customer_address")
    private String address;
    @Column(name="customer_phone")
    private String phone;
    @Column(name="customer_email_id")
    private String email;
}
