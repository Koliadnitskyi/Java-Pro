package com.example.homeworkfourteenglovo.service;

import com.example.homeworkfourteenglovo.model.Order;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
public class OrderService {
    private final Map<Long, Order> order = new HashMap<>();
    private final Random random = new Random();

    public Optional<Map.Entry<Long, Order>> getOrderById(Long id) {
        return order.entrySet().stream().filter(order -> order.getKey().equals(id)).findFirst();
    }

    public Map<Long, Order> getAll() {
        return this.order;
    }

    public Order save(Order orders) {
        orders.setId(this.random.nextInt());
        orders.setDate(LocalDate.now());
        order.put(orders.getId(), orders);
        return orders;
    }
}
