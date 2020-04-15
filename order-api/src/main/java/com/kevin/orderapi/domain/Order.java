package com.kevin.orderapi.domain;

import com.kevin.productapi.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private String placeUserId;
    private Product product;
    private LocalDateTime createTime;

}
