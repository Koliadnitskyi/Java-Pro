package com.example.homeworkfourteenglovo.controller;

import com.example.homeworkfourteenglovo.model.Order;
import com.example.homeworkfourteenglovo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Order save(@RequestBody Order order) {
        this.orderService.save(order);
        return order;
    }

    @GetMapping("/{id}")
    public Order getOrders(@PathVariable Long id) {
        return this.orderService.getById(id);
    }

    @GetMapping
    public List<Order> getOrder() {
        return this.orderService.getAll();
    }
}