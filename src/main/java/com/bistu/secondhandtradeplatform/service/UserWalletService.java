package com.bistu.secondhandtradeplatform.service;

import org.springframework.stereotype.Repository;

@Repository
public interface UserWalletService {
    int addUserWallet(String userId);
    String rechargeBalance(String userId, double money);
    String rechargePoint(String userId, double point);

}
