package com.example.homeworkfourteenglovo.controller;

import com.example.homeworkfourteenglovo.model.Order;
import com.example.homeworkfourteenglovo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order save(@RequestBody Order order) {
        this.orderService.save(order);
        return order;
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return this.orderService.get(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return this.orderService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public Order delete(@PathVariable Long id) {
        this.orderService.delete(id);
        return this.orderService.get(id);
    }

    @PutMapping("/update/{id}")
    public Order update(@RequestBody Order order, Long id) {
        this.orderService.update(order, id);
        return order;
    }
}