package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String productId;
    private String name;
    private BigDecimal productPrice;
    private BigDecimal count;
}
