package com.bistu.secondhandtradeplatform.entity;

import lombok.Data;

@Data
public class CartProduct {
    private String id;
    private String productImg;
    private String shop;
    private String name;
    private String price;
    private String count;
    private String sales;
    private String description;
    private String tradingStatus;
    private String productOperationMessage = "申请退货";
    private String cost;
}
