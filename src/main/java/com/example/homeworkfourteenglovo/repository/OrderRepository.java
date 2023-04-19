package com.example.homeworkfourteenglovo.repository;

import com.example.homeworkfourteenglovo.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(Order order) {
        jdbcTemplate.update("INSERT INTO Order VALUE (order_id, order_date, order_cost, order_product) values (?, ?, ?, ?)",
                order.getId(), order.getDate(), order.getCost(), order.getProduct());
    }
}
