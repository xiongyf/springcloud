package com.kevin.orderapi.controller;

import com.kevin.orderapi.domain.Order;
import com.kevin.orderapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order/{id}")
    public Order queryOrderById(@PathVariable("id") String id) {
        return this.orderService.getById(id);
    }
}