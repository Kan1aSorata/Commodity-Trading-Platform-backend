package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.UserWallet;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWalletService {
    int addUserWallet(String userId);
    UserWallet queryBalance(String userId);
    String rechargeBalance(String userId, double money);
    String rechargePoint(String userId, double point);
    String consumeWallet(String userId, double money, double point);
}
