package com.example.homeworkseventeenglovospringdatajdbc.service;

import com.example.homeworkseventeenglovospringdatajdbc.entity.OrderEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Order;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;
import com.example.homeworkseventeenglovospringdatajdbc.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

public class OrderServiceTest {
    private final OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
    private final OrderService orderService = Mockito.spy(new OrderService(orderRepository));

    @Test
    public void getTest() {
        OrderEntity tmp = new OrderEntity(23, LocalDate.of(2023, 1, 22), 23, 2, "Smetana", 234);
        Order expected = new Order(23, LocalDate.of(2023, 1, 22), 23, new Product(2, "Smetana", 234));
        Mockito.when(orderRepository.findById(Mockito.any())).thenReturn(Optional.of(tmp));
        OrderService orderService = new OrderService(orderRepository);
        Order actual = orderService.get(15);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest() {
        orderService.delete(12L);
        Mockito.verify(orderService, Mockito.times(1)).delete(12L);
    }

    @Test
    public void saveTest() {
        Order tmp = new Order(23, LocalDate.of(2023, 1, 22), 23, new Product(2, "Smetana", 234));
        orderService.save(tmp);
        Mockito.verify(orderService, Mockito.times(1)).save(tmp);
    }

    @Test
    public void updateTest() {
        Order tmp = new Order(55, LocalDate.of(2023, 1, 23), 23, new Product(2, "Smetana", 234));
        Order expected = new Order(55, LocalDate.of(2023, 1, 22), 23, new Product(2, "Smetana", 234));
        Order actual = orderService.update(tmp, 55L);
        Assertions.assertEquals(expected, actual);
    }
}