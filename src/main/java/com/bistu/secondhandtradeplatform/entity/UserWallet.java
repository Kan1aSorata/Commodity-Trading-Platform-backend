package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_wallet")
public class UserWallet {
    @TableId
    private String id;
    private double balance;
    private double point;
}
