package com.example.homeworkfourteenglovo.service;

import com.example.homeworkfourteenglovo.model.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OrderService {
    private final List<Order> order = new ArrayList<>();
    private final Random random = new Random();

    public Optional<Order> getOrderById(int id) {
        return order.stream().filter(order -> order.getId() == id).findFirst();
    }

    public List<Order> getAll() {
        return this.order;
    }

    public Order save(Order orders) {
        orders.setId(this.random.nextInt());
        orders.setDate(LocalDate.now());
        order.add(orders);
        return orders;
    }
}
