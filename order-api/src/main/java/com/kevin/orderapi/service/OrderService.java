package com.kevin.orderapi.service;

import com.kevin.orderapi.api.ProductApi;
import com.kevin.orderapi.domain.Order;
import com.kevin.productapi.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    ProductApi productApi;

    private static final Map<String, Order> ORDER_MAP = new HashMap<>();

    static {
        for (int i = 1; i <= 10; i++) {
            String id = i + "";
            Product product = Product.builder().id(id).build();
            Order order = Order.builder().id(id)
                    .createTime(LocalDateTime.now())
                    .placeUserId("userId" + id)
                    .product(product)
                    .build();
            ORDER_MAP.put(id, order);

        }
    }

    public Order getById(String id) {
        Order orderFromMap = ORDER_MAP.get(id);
        if (orderFromMap == null) {
            return Order.builder().build();
        }
        Order order = Order.builder()
                .id(orderFromMap.getId())
                .placeUserId(orderFromMap.getPlaceUserId())
                .createTime(orderFromMap.getCreateTime())
                .build();
        Product product = productApi.feignGetById(orderFromMap.getProduct().getId());
        order.setProduct(product);
        return order;
    }
}
