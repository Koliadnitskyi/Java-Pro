package com.example.homeworkfourteenglovo.controller;

import com.example.homeworkfourteenglovo.model.Order;
import com.example.homeworkfourteenglovo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public void save(@RequestBody Order order) {
        this.orderService.save(order);
    }
}