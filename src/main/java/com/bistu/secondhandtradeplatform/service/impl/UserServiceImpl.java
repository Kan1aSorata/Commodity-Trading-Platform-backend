package com.bistu.secondhandtradeplatform.service.impl;

import com.bistu.secondhandtradeplatform.entity.PurchaseHistory;
import com.bistu.secondhandtradeplatform.entity.User;
import com.bistu.secondhandtradeplatform.mapper.PurchaseHistoryMapper;
import com.bistu.secondhandtradeplatform.mapper.UserMapper;
import com.bistu.secondhandtradeplatform.service.PurchaseHistoryService;
import com.bistu.secondhandtradeplatform.service.UserService;
import com.bistu.secondhandtradeplatform.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserWalletService userWalletService;
    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @Override
    public String register(User user) {
        int i = userMapper.insert(user);
        int j = userWalletService.addUserWallet(user.getId());
        if (i != 0) {
            if (j != 0) {
                return "Register success.Add wallet success.";
            }
            return "Register success.";
        } else return "Register failure.";
    }

    @Override
    public String login(String userid, String password) {
        User user = userMapper.selectById(userid);
        if (Objects.equals(user.getPassword(), password)) {
            return "success.";
        } else {
            return "failure.";
        }
    }

    @Override
    public String changeInfo(User user) {
        if (userMapper.updateById(user) != 0) {
            return "success.";
        } else {
            return "failure.";
        }
    }

    @Override
    public String deleteUserById(String userId) {
        int i = userMapper.deleteById(userId);
        int j = purchaseHistoryService.deleteUserHistoryByUserId(userId);
        if (i != 0) {
            if (j != 0) {
                return "Delete success, Delete purchase history success.";
            }
            return "Delete success.";
        } else {
            return "Delete failure.";
        }
    }
}
