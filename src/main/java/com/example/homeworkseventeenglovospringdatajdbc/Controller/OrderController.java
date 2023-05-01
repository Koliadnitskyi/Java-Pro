package com.example.homeworkseventeenglovospringdatajdbc.Controller;

import com.example.homeworkseventeenglovospringdatajdbc.model.Order;
import com.example.homeworkseventeenglovospringdatajdbc.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return this.orderService.get(id);
    }

    @GetMapping
    public List<Order> getAll() {
        return this.orderService.getAll();
    }

    @DeleteMapping("/{id}")
    public Order delete(@PathVariable Long id) {
        this.orderService.delete(id);
        return this.orderService.get(id);
    }

    @PutMapping("/{id}")
    public Order update(@RequestBody Order order, @PathVariable Long id) {
        return this.orderService.update(order, id);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        this.orderService.save(order);
        return order;
    }
}
