package com.example.homeworkfourteenglovo.repository;

import com.example.homeworkfourteenglovo.model.Product;
import com.example.homeworkfourteenglovo.repository.mapper.ProductRowMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO Product VALUE (product_Id, product_Name, product_Cost) values (?, ?, ?)",
                product.getId(), product.getName(), product.getCost());
    }

    public Product get(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_id = " + id, new ProductRowMapper());
    }

    public List<Product> getAll() {
        return Collections.singletonList(jdbcTemplate.queryForObject("SELECT * FROM product", new ProductRowMapper()));
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM product WHERE id =" + id);
    }

    public void update(Product product, Long id) {
        jdbcTemplate.update("UPDATE Order SET product_Name = " + product.getName()
                + ", product_Cost = " + product.getCost()
                + "WHERE contact_id = " + id);
    }
}
