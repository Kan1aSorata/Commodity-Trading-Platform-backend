package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.ShippingAddress;
import com.bistu.secondhandtradeplatform.mapper.ShippingAddressMapper;
import com.bistu.secondhandtradeplatform.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressMapper shippingAddressMapper;
    QueryWrapper<ShippingAddress> queryWrapper = new QueryWrapper<>();

    @Override
    public String addAddress(String userId, String address) {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setUserId(userId);
        shippingAddress.setAddress(address);
        if (shippingAddressMapper.insert(shippingAddress) != 0) {
            return "Add success.";
        } else return "failure.";
    }

    @Override
    public String deleteAddress(String userId, String address) {
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("address", address);
        if (shippingAddressMapper.delete(queryWrapper) != 0) {
            return "delete success.";
        } else return "failure";
    }

    @Override
    public List<ShippingAddress> getAddress(String userId) {
        queryWrapper.eq("user_id", userId);
        return shippingAddressMapper.selectList(queryWrapper);
    }
}
