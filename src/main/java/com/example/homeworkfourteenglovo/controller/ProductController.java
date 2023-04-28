package com.example.homeworkfourteenglovo.controller;

import com.example.homeworkfourteenglovo.model.Product;
import com.example.homeworkfourteenglovo.service.ProductServise;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductServise productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        this.productService.save(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return this.productService.get(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return this.productService.getAll();
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) {
        this.productService.delete(id);
        return this.productService.get(id);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        this.productService.update(product, id);
        return product;
    }
}
