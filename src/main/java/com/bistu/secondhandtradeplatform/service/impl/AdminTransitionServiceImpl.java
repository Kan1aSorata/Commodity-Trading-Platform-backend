package com.bistu.secondhandtradeplatform.service.impl;

import com.bistu.secondhandtradeplatform.entity.AdminTransition;
import com.bistu.secondhandtradeplatform.entity.User;
import com.bistu.secondhandtradeplatform.mapper.AdminMapper;
import com.bistu.secondhandtradeplatform.service.AdminTransitionService;
import com.bistu.secondhandtradeplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminTransitionServiceImpl implements AdminTransitionService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserService userService;

    @Override
    public String register(AdminTransition adminTransition) {
        adminTransition.setAdmin(true);
        if (adminMapper.insert(adminTransition) != 0) {
            return "success.";
        } else return "failure.";
    }

    @Override
    public List<AdminTransition> list() {
        return adminMapper.selectList(null);
    }

    @Override
    public String adminVerify(String adminId, boolean result) {
        if (result) {
            AdminTransition adminTransition = adminMapper.selectById(adminId);
            User user = new User();
            user.setId(adminTransition.getId());
            user.setName(adminTransition.getName());
            user.setPhone(adminTransition.getPhone());
            user.setEmail(adminTransition.getEmail());
            user.setCity(adminTransition.getCity());
            user.setSex(adminTransition.getSex());
            user.setBank(adminTransition.getBank());
            user.setType(adminTransition.getType());
            user.setAdmin(adminTransition.isAdmin());
            user.setPassword(adminTransition.getPassword());
            userService.register(user);
            adminMapper.deleteById(adminId);
            return "success.";
        } else return "failure";
    }
}
