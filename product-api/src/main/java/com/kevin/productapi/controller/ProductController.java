package com.kevin.productapi.controller;

import com.kevin.productapi.domain.Product;
import com.kevin.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/{id}")
    public Product queryOrderById(@PathVariable("id") String id) {
        return this.productService.getById(id);
    }
}