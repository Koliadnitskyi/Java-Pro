package com.example.homeworkseventeenglovospringdatajdbc.converter;

import com.example.homeworkseventeenglovospringdatajdbc.entity.OrderEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Order;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

public class OrderConverterTest {
    @Test
    public void orderToOrderEntityTest() {
        OrderEntity expected = new OrderEntity(23, LocalDate.of(2023, 1, 22), 23, 2, "Smetana", 234);
        OrderEntity actual = OrderConverter.orderToOrderEntity(new Order(23, LocalDate.of(2023, 1, 22), 23, new Product(2, "Smetana", 234)));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void orderEntityToOrderTest() {
        Order expected = new Order(23, LocalDate.of(2023, 1, 22), 23, new Product(2, "Smetana", 234));
        Order actual = OrderConverter.orderEntityToOrder(new OrderEntity(23, LocalDate.of(2023, 1, 22), 23, 2, "Smetana", 234));
        Assertions.assertEquals(expected, actual);
    }
}
