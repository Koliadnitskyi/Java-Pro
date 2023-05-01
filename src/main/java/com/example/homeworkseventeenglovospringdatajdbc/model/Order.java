package com.example.homeworkseventeenglovospringdatajdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Data
public class Order {
    private long id;
    private LocalDate date;
    private int cost;
    private Product product;
}
