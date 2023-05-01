package com.example.homeworkseventeenglovospringdatajdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Builder
@Table("product")
public class ProductEntity {
    @Id
    private long productId;
    private String productName;
    private int productCost;
}
