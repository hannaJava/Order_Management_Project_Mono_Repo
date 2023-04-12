package com.genspark.OM_OrderMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String username;
    private String address;
    private String password;
    private String email;
    private String phone;
}
