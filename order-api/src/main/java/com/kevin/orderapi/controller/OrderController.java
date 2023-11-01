package com.kevin.orderapi.controller;

import com.kevin.orderapi.api.ProductApi;
import com.kevin.orderapi.domain.Order;
import com.kevin.orderapi.service.OrderProducerService;
import com.kevin.orderapi.service.OrderService;
import com.kevin.productapi.domain.Product;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Api("order")
@EnableSwagger2Doc
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductApi productApi;

    @Autowired
    private   OrderProducerService orderProducerService;

    @Value("${kafka.topic.my-topic}")
    String myTopic;
    @Value("${kafka.topic.my-topic2}")
    String myTopic2;

    @ApiOperation("queryOrderById")
    @GetMapping(value = "/order/{id}")
    public Order queryOrderById(@PathVariable("id") String id) {
        return this.orderService.getById(id);
    }

    @PostMapping(value = "/product")
    public void queryOrderById(@RequestBody Product product) {
        productApi.update(product);
    }

    @PostMapping("/order")
    public void sendMessageToKafkaTopic(@RequestParam("userId") String userId) {
        orderProducerService.sendMessage(myTopic, Order.builder().placeUserId(userId).build());
    }
}