package com.example.homeworkseventeenglovospringdatajdbc.converter;

import com.example.homeworkseventeenglovospringdatajdbc.entity.OrderEntity;
import com.example.homeworkseventeenglovospringdatajdbc.entity.ProductEntity;
import com.example.homeworkseventeenglovospringdatajdbc.model.Product;

public class ProductConverter {
    public static Product productEntityToProduct(ProductEntity productEntity) {
        return Product
                .builder()
                .id(productEntity.getProductId())
                .name(productEntity.getProductName())
                .cost(productEntity.getProductCost())
                .build();
    }

    public static ProductEntity productToProductEntity(Product product) {
        return ProductEntity
                .builder()
                .productId(product.getId())
                .productName(product.getName())
                .productCost(product.getCost())
                .build();
    }
}
