package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.UserTradeRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTradeRecordService {
    String addTradeRecord(String userId, double money, double point);
    List<UserTradeRecord> getTradeRecord(String userId);
}
