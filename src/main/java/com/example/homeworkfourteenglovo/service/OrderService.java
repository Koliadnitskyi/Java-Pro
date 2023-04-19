package com.example.homeworkfourteenglovo.service;

import com.example.homeworkfourteenglovo.model.Order;
import com.example.homeworkfourteenglovo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;

    private final Random random = new Random();

    public void save(Order orders) {
        orders.setId(this.random.nextInt());
        orders.setDate(LocalDate.now());
        orderRepository.save(orders);
    }
}
