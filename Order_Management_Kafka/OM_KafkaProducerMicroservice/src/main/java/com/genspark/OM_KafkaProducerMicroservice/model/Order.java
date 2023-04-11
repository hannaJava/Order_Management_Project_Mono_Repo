package com.genspark.OM_KafkaProducerMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long customerId;
    private Long productId;
    private Integer qt;
    private Double unitPrice;
}
