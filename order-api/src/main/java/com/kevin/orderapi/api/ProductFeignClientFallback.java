package com.kevin.orderapi.api;

import com.kevin.productapi.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product queryById(String id) {
        return Product.builder().id("x").title("error").build();
    }

    @Override
    public void update(Product product) {

    }
}
