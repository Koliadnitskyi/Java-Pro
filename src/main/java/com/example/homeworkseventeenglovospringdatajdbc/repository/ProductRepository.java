package com.example.homeworkseventeenglovospringdatajdbc.repository;

import com.example.homeworkseventeenglovospringdatajdbc.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}