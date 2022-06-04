package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_trade_record")
public class UserTradeRecord {
    @TableId
    private String tradeId;
    private String id;
    private double moneyTrade;
    private double pointTrade;
    private Date time;
}
