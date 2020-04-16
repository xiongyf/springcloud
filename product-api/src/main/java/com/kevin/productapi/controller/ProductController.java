package com.kevin.productapi.controller;

import com.kevin.productapi.domain.Product;
import com.kevin.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/{id}")
    public Product queryById(@PathVariable("id") String id) {
        return this.productService.getById(id);
    }

    @PostMapping(value = "/product")
    public void update(@RequestBody Product product) {
        System.out.println("update product:");
        System.out.println(product);
    }
}