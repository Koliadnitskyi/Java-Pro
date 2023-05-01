package com.example.homeworkseventeenglovospringdatajdbc.converter;

import com.example.homeworkseventeenglovospringdatajdbc.entity.OrderEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Order;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;

public class OrderConverter {
    public static Order orderEntityToOrder(OrderEntity orderEntity) {
        return Order
                .builder()
                .id(orderEntity.getOrderId())
                .date(orderEntity.getOrderDate())
                .cost(orderEntity.getOrderCost())
                .product(Product
                        .builder()
                        .id(orderEntity.getOrderProductId())
                        .name(orderEntity.getOrderProductName())
                        .cost(orderEntity.getOrderProductCost())
                        .build())
                .build();
    }

    public static OrderEntity orderToOrderEntity(Order order) {
        return OrderEntity
                .builder()
                .orderId(order.getId())
                .orderDate(order.getDate())
                .orderCost(order.getCost())
                .orderProductId(order.getProduct().getId())
                .orderProductName(order.getProduct().getName())
                .orderProductCost(order.getProduct().getCost())
                .build();
    }
}
