package com.example.homeworkseventeenglovospringdatajdbc.repository;

import com.example.homeworkseventeenglovospringdatajdbc.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}