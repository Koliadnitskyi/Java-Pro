package com.example.homeworkfourteenglovo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private long id;
    private LocalDate date;
    private int cost;
    private Product product;
}
