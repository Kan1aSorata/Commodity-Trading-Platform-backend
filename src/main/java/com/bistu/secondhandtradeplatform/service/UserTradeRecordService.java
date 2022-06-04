package com.bistu.secondhandtradeplatform.service;

import org.springframework.stereotype.Repository;

@Repository
public interface UserTradeRecordService {
    String addTradeRecord(String userId, double money, double point);
}
