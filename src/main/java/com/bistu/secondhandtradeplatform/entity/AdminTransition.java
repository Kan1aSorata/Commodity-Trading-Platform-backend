package com.bistu.secondhandtradeplatform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("adminTransition")
public class AdminTransition {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String city;
    private String sex;
    private String bank;
    private String password;
    private int type;
    private boolean admin;
}
