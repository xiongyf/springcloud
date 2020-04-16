package com.kevin.orderapi.controller;

import com.kevin.orderapi.api.ProductApi;
import com.kevin.orderapi.domain.Order;
import com.kevin.orderapi.service.OrderService;
import com.kevin.productapi.domain.Product;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("order")
@EnableSwagger2Doc
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductApi productApi;

    @ApiOperation("queryOrderById")
    @GetMapping(value = "/order/{id}")
    public Order queryOrderById(@PathVariable("id") String id) {
        return this.orderService.getById(id);
    }

    @PostMapping(value = "/product")
    public void queryOrderById(@RequestBody Product product) {
        productApi.update(product);
    }
}