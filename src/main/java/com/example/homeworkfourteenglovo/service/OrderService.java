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

    public Order get(Long id) {
        return orderRepository.getById(id);
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public void update(Order orders, Long id) {
        orderRepository.updateById(orders, id);
    }
}
