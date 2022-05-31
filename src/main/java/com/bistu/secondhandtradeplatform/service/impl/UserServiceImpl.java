package com.bistu.secondhandtradeplatform.service.impl;

import com.bistu.secondhandtradeplatform.entity.User;
import com.bistu.secondhandtradeplatform.mapper.UserMapper;
import com.bistu.secondhandtradeplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String register(User user) {
        if (userMapper.insert(user) != 0) {
            return "success.";
        } else return "failure.";
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
}
