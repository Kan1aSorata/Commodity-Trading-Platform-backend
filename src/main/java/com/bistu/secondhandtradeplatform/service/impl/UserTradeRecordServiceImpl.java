package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.UserTradeRecord;
import com.bistu.secondhandtradeplatform.mapper.UserTradeRecordMapper;
import com.bistu.secondhandtradeplatform.service.UserTradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserTradeRecordServiceImpl implements UserTradeRecordService {

    @Autowired
    private UserTradeRecordMapper userTradeRecordMapper;

    @Override
    public String addTradeRecord(String userId, double money, double point) {
        UserTradeRecord userTradeRecord = new UserTradeRecord();
        userTradeRecord.setTradeId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        userTradeRecord.setId(userId);
        userTradeRecord.setMoneyTrade(money);
        userTradeRecord.setPointTrade(point);
        userTradeRecord.setTime(new Date());
        if (userTradeRecordMapper.insert(userTradeRecord) != 0) {
            return "success.";
        } else {
            return "failure.";
        }
    }
    @Override
    public List<UserTradeRecord> getTradeRecord(String userId) {
        QueryWrapper<UserTradeRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return userTradeRecordMapper.selectList(queryWrapper);
    }
}
