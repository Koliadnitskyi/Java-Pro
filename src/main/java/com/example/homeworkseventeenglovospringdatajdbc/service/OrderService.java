package com.example.homeworkseventeenglovospringdatajdbc.service;

import com.example.homeworkseventeenglovospringdatajdbc.converter.OrderConverter;
import com.example.homeworkseventeenglovospringdatajdbc.entity.OrderEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Order;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;
import com.example.homeworkseventeenglovospringdatajdbc.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order get(long id) {
        return OrderConverter.orderEntityToOrder(this.orderRepository.findById(id).orElseThrow());
    }

    public List<Order> getAll() {
        return Collections.singletonList(OrderConverter.orderEntityToOrder((OrderEntity) this.orderRepository.findAll()));
    }

    public void delete(long id) {
        this.orderRepository.deleteAllById(Collections.singleton(id));
    }

    public void save(Order order) {
        this.orderRepository.save(OrderConverter.orderToOrderEntity(order));
    }

    public Order update(Order order, Long id) {
        Order tmp = OrderConverter.orderEntityToOrder(this.orderRepository.findById(id).orElseThrow());
        tmp.setDate(order.getDate());
        tmp.setCost(order.getCost());
        tmp.setProduct(Product
                .builder()
                .id(order.getProduct().getId())
                .name(order.getProduct().getName())
                .cost(order.getProduct().getCost())
                .build());
        this.orderRepository.save(OrderConverter.orderToOrderEntity(tmp));
        return tmp;
    }
}
