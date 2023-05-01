package com.example.homeworkseventeenglovospringdatajdbc.service;

import com.example.homeworkseventeenglovospringdatajdbc.converter.ProductConverter;
import com.example.homeworkseventeenglovospringdatajdbc.entity.ProductEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;
import com.example.homeworkseventeenglovospringdatajdbc.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product get(long id) {
        return ProductConverter.productEntityToProduct(this.productRepository.findById(id).orElseThrow());
    }

    public List<Product> getAll() {
        return Collections.singletonList(ProductConverter.productEntityToProduct((ProductEntity) this.productRepository.findAll()));
    }

    public void delete(long id) {
        this.productRepository.deleteAllById(Collections.singleton(id));
    }

    public void save(Product product) {
        this.productRepository.save(ProductConverter.productToProductEntity(product));
    }

    public Product update(Product product, Long id) {
        Product tmp = ProductConverter.productEntityToProduct(this.productRepository.findById(id).orElseThrow());
        tmp.setId(product.getId());
        tmp.setName(product.getName());
        tmp.setCost(product.getCost());
        this.productRepository.save(ProductConverter.productToProductEntity(tmp));
        return tmp;
    }
}
