package com.bistu.secondhandtradeplatform.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private List<CartProduct> cartProducts;
    private double sum;
}
