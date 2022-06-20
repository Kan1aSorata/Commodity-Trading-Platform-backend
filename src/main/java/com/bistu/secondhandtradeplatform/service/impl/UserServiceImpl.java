package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.User;
import com.bistu.secondhandtradeplatform.entity.UserTransition;
import com.bistu.secondhandtradeplatform.mapper.UserMapper;
import com.bistu.secondhandtradeplatform.mapper.UserTransitionMapper;
import com.bistu.secondhandtradeplatform.service.PurchaseHistoryService;
import com.bistu.secondhandtradeplatform.service.UserService;
import com.bistu.secondhandtradeplatform.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserWalletService userWalletService;
    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @Autowired
    private UserTransitionMapper userTransitionMapper;

    QueryWrapper<User> queryWrapper = new QueryWrapper<>();

    @Override
    public String register(UserTransition userTransition) {
        userTransition.setAdmin(false);
        if (userTransitionMapper.insert(userTransition) != 0) {
            return "Register success.";
        } else return "Register failure.";
    }

    @Override
    public List<UserTransition> list() {
        return userTransitionMapper.selectList(null);
    }

    @Override
    public String userVerify(String id, boolean result) {
        if (result) {
            UserTransition userTransition = userTransitionMapper.selectById(id);
            User user = new User();
            user.setId(userTransition.getId());
            user.setName(userTransition.getName());
            user.setPhone(userTransition.getPhone());
            user.setEmail(userTransition.getEmail());
            user.setCity(userTransition.getCity());
            user.setSex(userTransition.getSex());
            user.setBank(userTransition.getBank());
            user.setType(userTransition.getType());
            user.setAdmin(userTransition.isAdmin());
            user.setPassword(userTransition.getPassword());
            userMapper.insert(user);
            userWalletService.addUserWallet(userTransition.getId());
            userTransitionMapper.deleteById(id);
            return "Accept success.";
        } else {
            userTransitionMapper.deleteById(id);
            return "Reject success.";
        }
    }

    @Override
    public String login(String userid, String password) {
        User user = userMapper.selectById(userid);
        if (user == null) {
            return "没有这个用户";
        }
        if (Objects.equals(user.getPassword(), password)) {
            return "success.";
        } else {
            return "密码错误";
        }
    }

    @Override
    public User getUserInfo(String id) {
        return userMapper.selectById(id);
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
