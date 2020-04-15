package com.kevin.orderapi.api;

import com.kevin.productapi.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductApi {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductFeignClient productFeignClient;

    @HystrixCommand(fallbackMethod = "getByIdFallbackMethod")
    public Product getById(String id) {
        return this.restTemplate.getForObject("http://product-api/product/" + id, Product.class);
    }

    public Product feignGetById(String id) {
        return productFeignClient.queryById(id);
    }

    public Product getByIdFallbackMethod(String id) {
        return Product.builder().id("x").title("error").build();
    }

}
