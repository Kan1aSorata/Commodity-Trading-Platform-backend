package com.bistu.secondhandtradeplatform.controller;

import com.bistu.secondhandtradeplatform.entity.User;
import com.bistu.secondhandtradeplatform.mapper.AdminMapper;
import com.bistu.secondhandtradeplatform.mapper.UserMapper;
import com.bistu.secondhandtradeplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /*
    用户注册
     */
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    /*
    用户登录
     */
    @GetMapping("/login")
    public String login(String userId, String password) {
        return userService.login(userId, password);
    }

    /*
    用户列表
     */
    @GetMapping("/list")
    public void list() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /*
    用户个人信息更改
     */
    @PostMapping("/changeInfo")
    public String changeInfo(@RequestBody User user) {
        return userService.changeInfo(user);
    }
}
