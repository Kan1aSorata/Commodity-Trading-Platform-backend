package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("commodity_Transition")
public class CommodityTransition {
    @TableId
    private String commodityId;
    private String name;
    private double price;
    private String category;
    private String picture;
    private String description;
    private int stock;
    private String shop;
}
