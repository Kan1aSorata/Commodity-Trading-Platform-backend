package com.bistu.secondhandtradeplatform.controller;

import com.bistu.secondhandtradeplatform.entity.AdminTransition;
import com.bistu.secondhandtradeplatform.service.AdminTransitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminTransition")
public class AdminTransitionController {
    @Autowired
    private AdminTransitionService adminTransitionService;

    @PostMapping("/register")
    public String register(@RequestBody AdminTransition adminTransition) {
        return adminTransitionService.register(adminTransition);
    }

    @GetMapping("/list")
    public List<AdminTransition> list() {
        return adminTransitionService.list();
    }

    @GetMapping("adminVerify")
    public String adminVerify(String adminId, boolean result) {
        return adminTransitionService.adminVerify(adminId, result);
    }
}
