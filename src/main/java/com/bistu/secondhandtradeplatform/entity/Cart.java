package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cart")
public class Cart {
    private int id;
    private String userId;
    private String commoditySku;
}
