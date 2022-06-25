package com.bistu.secondhandtradeplatform.controller;


import com.bistu.secondhandtradeplatform.entity.CommodityTransition;
import com.bistu.secondhandtradeplatform.entity.UserTransition;
import com.bistu.secondhandtradeplatform.service.CommodityTransitionService;
import com.bistu.secondhandtradeplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommodityTransitionService commodityTransitionService;
    @Autowired

    /*
    当前待审核用户列表
     */
    @RequestMapping("/list")
    public List<UserTransition> list() {
        return userService.list();
    }

    /*
    true: 通过
    false: 拒绝
     */
    @RequestMapping("/userVerify")
    public String userVerify(String id, boolean result) {
        return userService.userVerify(id, result);
    }

    @GetMapping("/listCommodity")
    public List<CommodityTransition> listCommodity() {
        return commodityTransitionService.list();
    }

    /*
    true: 通过
    false: 拒绝
     */
    @GetMapping("/commodityVerify")
    public String commodityVerify(String id, boolean result) {
        return commodityTransitionService.commodityVerify(id, result);
    }
}
