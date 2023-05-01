package com.example.homeworkseventeenglovospringdatajdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Product {
    private long id;
    private String name;
    private int cost;
}
