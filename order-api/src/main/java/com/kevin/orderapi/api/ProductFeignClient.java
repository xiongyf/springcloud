package com.kevin.orderapi.api;

import com.kevin.productapi.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "product-api", fallback = ProductFeignClientFallback.class)
public interface ProductFeignClient {

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    Product queryById(@PathVariable("id") String id);

    @PostMapping(value = "/product")
    void update(Product product);
}
