package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("commodity")
public class Commodity {
    @TableId
    private String sku;
    private String name;
    private double price;
    private String category;
    private String picture;
    private String description;
    private int stock;
    private int sales;
    private double score;
}
