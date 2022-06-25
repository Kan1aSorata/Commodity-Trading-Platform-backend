package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("purchaseHistory")
public class PurchaseHistory {
    @TableId
    private String orderId;
    private String id;
    private String sku;
    private int count;
    private double price;
    private double payment;
    private Date purchaseTime;
    private int status;
    private String shop;
    private String picture;
}
