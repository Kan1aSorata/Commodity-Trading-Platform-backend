package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.UserWallet;
import com.bistu.secondhandtradeplatform.mapper.UserWalletMapper;
import com.bistu.secondhandtradeplatform.service.UserTradeRecordService;
import com.bistu.secondhandtradeplatform.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWalletServiceImpl implements UserWalletService {
    @Autowired
    private UserWalletMapper userWalletMapper;
    @Autowired
    private UserTradeRecordService userTradeRecordService;
    QueryWrapper<UserWallet> queryWrapper = new QueryWrapper<>();

    @Override
    public int addUserWallet(String userId) {
        UserWallet userWallet = new UserWallet();
        userWallet.setId(userId);
        int i = userWalletMapper.insert(userWallet);
        if (i != 0) {
            return i;
        } else return 0;
    }

    @Override
    public UserWallet queryBalance(String userId) {
        return userWalletMapper.selectById(userId);
    }

    @Override
    public String rechargeBalance(String userId, double money) {
        UserWallet userWallet = userWalletMapper.selectById(userId);
        userWallet.setBalance(userWallet.getBalance() + money);
        if (userWalletMapper.updateById(userWallet) != 0) {
            userTradeRecordService.addTradeRecord(userId, money, 0);
            return "success.";
        } else {
            return "failure.";
        }
    }

    @Override
    public String rechargePoint(String userId, double point) {
        UserWallet userWallet = userWalletMapper.selectById(userId);
        userWallet.setPoint(userWallet.getPoint() + point);
        if (userWalletMapper.updateById(userWallet) != 0) {
            userTradeRecordService.addTradeRecord(userId, 0, point);
            return "success.";
        } else {
            return "failure.";
        }
    }

    @Override
    public String consumeWallet(String userId, double money, double point) {
        UserWallet userWallet = userWalletMapper.selectById(userId);
        if (userWallet.getBalance() - money < 0) {
            return "您当前余额为" + userWallet.getBalance() + "不足以支付所需的" + point + "元";
        }
        if (userWallet.getPoint() - point < 0) {
            return "您当前积分为" + userWallet.getPoint() + "不足以支付所需的" + point + "点积分";
        }
        userWallet.setBalance(userWallet.getBalance() - money);
        userWallet.setPoint(userWallet.getPoint() - point + money);
        userTradeRecordService.addTradeRecord(userId, -money, -point);

        if (userWalletMapper.updateById(userWallet) != 0) {
            return "success.";
        } else {
            return "failure.";
        }
    }


}
