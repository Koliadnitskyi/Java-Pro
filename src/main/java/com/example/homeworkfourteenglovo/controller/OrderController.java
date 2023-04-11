package com.example.homeworkfourteenglovo.controller;

import com.example.homeworkfourteenglovo.model.Order;
import com.example.homeworkfourteenglovo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrder() {
        return this.orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getOrders(@PathVariable Integer id) {
        return this.orderService.getOrderById(id).orElseThrow();
    }

    @GetMapping
    public Order save(@RequestBody Order order) {
        return this.orderService.save(order);
    }
}