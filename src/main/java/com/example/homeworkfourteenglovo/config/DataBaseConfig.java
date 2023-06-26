package com.example.homeworkfourteenglovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {
    @Bean
    public DataSource create() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver ");
        dataSource.setUrl("jdbs:postgresql://localHost:5432/dvdrental");
        dataSource.setUsername("postgres");
        dataSource.setPassword("mysecretpassword");
        return dataSource;
    }
}
