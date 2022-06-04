package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.PurchaseHistory;
import com.bistu.secondhandtradeplatform.mapper.PurchaseHistoryMapper;
import com.bistu.secondhandtradeplatform.service.PurchaseHistoryService;
import com.bistu.secondhandtradeplatform.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    @Autowired
    private PurchaseHistoryMapper purchaseHistoryMapper;

    QueryWrapper<PurchaseHistory> queryWrapper = new QueryWrapper<>();

    @Override
    public String addHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setOrderId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        if (purchaseHistoryMapper.insert(purchaseHistory) != 0) {
            return purchaseHistory.getOrderId();
        } else return "Insert failure.";
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoryByUserId(String userId) {
        queryWrapper.eq("id", userId);
        return purchaseHistoryMapper.selectList(queryWrapper);
    }

    @Override
    public int deleteUserHistoryByUserId(String userId) {
        queryWrapper.eq("id", userId);
        int i = purchaseHistoryMapper.delete(queryWrapper);
        if (i != 0) {
            return i;
        } else return 0;
    }
}
