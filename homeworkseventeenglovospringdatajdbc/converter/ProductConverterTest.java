package com.example.homeworkseventeenglovospringdatajdbc.converter;

import com.example.homeworkseventeenglovospringdatajdbc.entity.ProductEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductConverterTest {
    @Test
    public void productToProductEntityTest() {
        ProductEntity expected = new ProductEntity(2, "Smetana", 234);
        ProductEntity actual = ProductConverter.productToProductEntity(new Product(2, "Smetana", 234));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void productEntityToProductTest() {
        Product expected = new Product(2, "Smetana", 234);
        Product actual = ProductConverter.productEntityToProduct(new ProductEntity(2, "Smetana", 234));
        Assertions.assertEquals(expected, actual);
    }
}
