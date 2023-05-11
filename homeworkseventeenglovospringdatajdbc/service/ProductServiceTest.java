package com.example.homeworkseventeenglovospringdatajdbc.service;

import com.example.homeworkseventeenglovospringdatajdbc.entity.ProductEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;
import com.example.homeworkseventeenglovospringdatajdbc.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Optional;

public class ProductServiceTest {
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final ProductService productService = Mockito.spy(new ProductService(productRepository));

    @Test
    public void getTest() {
        ProductEntity tmp = new ProductEntity(2, "Smetana", 234);
        Product expected = new Product(2, "Smetana", 234);
        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(tmp));
        ProductService productService = new ProductService(productRepository);
        Product actual = productService.get(15);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest() {
        productService.delete(12L);
        Mockito.verify(productService, Mockito.times(1)).delete(12L);
    }

    @Test
    public void saveTest() {
        Product tmp = new Product(2, "Smetana", 234);
        productService.save(tmp);
        Mockito.verify(productService, Mockito.times(1)).save(tmp);
    }

    @Test
    public void updateTest() {
        Product tmp = new Product(2, "Smetana", 234);
        Product expected = new Product(2, "Smetana", 234);
        Product actual = productService.update(tmp, 55L);
        Assertions.assertEquals(expected, actual);
    }
}
