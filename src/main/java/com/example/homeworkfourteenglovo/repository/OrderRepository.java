package com.example.homeworkfourteenglovo.repository;

import com.example.homeworkfourteenglovo.model.Order;
import com.example.homeworkfourteenglovo.repository.mapper.OrderRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(Order order) {
        jdbcTemplate.update("INSERT INTO Order VALUE (order_id, order_date, order_cost, order_product_Id, order_product_Name, order_product_Cost) values (?, ?, ?, ?, ?, ?)",
                order.getId(), order.getDate(), order.getCost(), order.getProduct().getId(), order.getProduct().getName(), order.getProduct().getCost());
    }

    public Order getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM order WHERE order_id = " + id, new OrderRowMapper());
    }

    public List<Order> getAll() {
        return Collections.singletonList(jdbcTemplate.queryForObject("SELECT * FROM order", new OrderRowMapper()));
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM order WHERE id =" + id);
    }

    public void updateById(Order order, Long id) {
        jdbcTemplate.update("UPDATE Order SET order_cost = " + order.getCost()
                + ", order_product_Id = " + order.getProduct().getId()
                + ", order_product_Name = " + order.getProduct().getName()
                + ", order_product_Cost = " + order.getProduct().getCost()
                + "WHERE contact_id = " + id);
    }
}
