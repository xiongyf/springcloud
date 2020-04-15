package com.kevin.productapi.service;

import com.kevin.productapi.domain.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private static final Map<String, Product> PRODUCT_MAP = new HashMap<>();

    static {
        for (int i = 1; i <= 10; i++) {
            String id = i + "";
            PRODUCT_MAP.put(id, Product.builder()
                    .id(id)
                    .title("product" + i)
                    .build()
            );

        }
    }

    public Product getById(String id) {
        return PRODUCT_MAP.get(id);
    }
}
