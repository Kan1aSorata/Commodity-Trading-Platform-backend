package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("shipping_address")
public class ShippingAddress {
    private int id;
    private String userId;
    private String address;
}
