package com.example.homeworkfourteenglovo.repository.mapper;

import com.example.homeworkfourteenglovo.model.Order;
import com.example.homeworkfourteenglovo.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getInt(1))
                .date(rs.getDate(2).toLocalDate())
                .cost(rs.getInt(3))
                .product(new Product(rs.getInt(4), rs.getString(5), rs.getInt(6)))
                .build();
    }
}
