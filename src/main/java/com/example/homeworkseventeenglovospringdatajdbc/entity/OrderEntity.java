package com.example.homeworkseventeenglovospringdatajdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@Table("order")
public class OrderEntity {
    @Id
    private long orderId;
    private LocalDate orderDate;
    private int orderCost;
    private long orderProductId;
    private String orderProductName;
    private int orderProductCost;
}