package com.bistu.secondhandtradeplatform.controller;

import com.bistu.secondhandtradeplatform.entity.*;
import com.bistu.secondhandtradeplatform.mapper.UserMapper;
import com.bistu.secondhandtradeplatform.service.PurchaseHistoryService;
import com.bistu.secondhandtradeplatform.service.ShippingAddressService;
import com.bistu.secondhandtradeplatform.service.UserService;
import com.bistu.secondhandtradeplatform.service.UserWalletService;
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
    @Autowired
    private PurchaseHistoryService purchaseHistoryService;
    @Autowired
    private UserWalletService userWalletService;
    @Autowired
    private ShippingAddressService shippingAddressService;

    /*
    用户注册
     */
    @PostMapping("/register")
    public String register(@RequestBody UserTransition userTransition) {
        return userService.register(userTransition);
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
    public List<User> list() {
        return userMapper.selectList(null);
    }

    /*
    用户信息获取
     */
    @GetMapping("/getUserInfo")
    public User getUserInfo(String id) {
        return userService.getUserInfo(id);
    }

    /*
    用户个人信息更改
     */
    @PostMapping("/changeInfo")
    public String changeInfo(@RequestBody User user) {
        return userService.changeInfo(user);
    }

    @GetMapping("/deleteUser")
    public String deleteUserById(String userId) {
        return userService.deleteUserById(userId);
    }

    @GetMapping("/purchase")
    public String purchase(String userId, String sku) {
        return purchaseHistoryService.addHistory(userId, sku);
    }

    /*
        status: 已发货 - 1，待收货 - 2，运输中 - 3，已收货 - 4，退货中 - 5，交易完成 - 0
         */
    @GetMapping("/setPurchaseStatus")
    public String setPurchaseStatus(String userId, String sku, int status) {
        return purchaseHistoryService.setPurchaseStatus(userId, sku, status);
    }

    @GetMapping("/purchaseHistory")
    public List<PurchaseHistory> getPurchaseHistory(String userId) {
        return purchaseHistoryService.getPurchaseHistoryByUserId(userId);
    }

    @GetMapping("/queryBalance")
    public UserWallet queryBalance(String userId) {
        return userWalletService.queryBalance(userId);
    }

    @GetMapping("/rechargeBalance")
    public String rechargeBalance(String userId, Double money) {
        return userWalletService.rechargeBalance(userId, money);
    }

    @GetMapping("/rechargePoint")
    public String rechargePoint(String userId, Double point) {
        return userWalletService.rechargePoint(userId, point);
    }

    @GetMapping("/payment")
    public String payment(String userId, double money) {
        return userWalletService.consumeWallet(userId, money);
    }

    @GetMapping("/addAddress")
    public String addAddress(String userId, String address) {
        return shippingAddressService.addAddress(userId, address);
    }

    @GetMapping("/deleteAddress")
    public String deleteAddress(String userId, String address) {
        return shippingAddressService.deleteAddress(userId, address);
    }

    @GetMapping("/getAddress")
    public List<ShippingAddress> getAddress(String userId) {
        return shippingAddressService.getAddress(userId);
    }

}
