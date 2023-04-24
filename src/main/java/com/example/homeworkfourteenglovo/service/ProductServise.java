package com.example.homeworkfourteenglovo.service;

import com.example.homeworkfourteenglovo.model.Product;
import com.example.homeworkfourteenglovo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductServise {
    ProductRepository productRepository;

    private final Random random = new Random();

    public void save(Product product) {
        product.setId(this.random.nextInt());
        productRepository.save(product);
    }

    public Product get(Long id) {
        return productRepository.getById(id);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void update(Product product, Long id) {
        productRepository.updateById(product, id);
    }
}