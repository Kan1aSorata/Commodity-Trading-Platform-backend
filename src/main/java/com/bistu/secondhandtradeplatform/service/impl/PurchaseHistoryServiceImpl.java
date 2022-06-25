package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.Commodity;
import com.bistu.secondhandtradeplatform.entity.PurchaseHistory;
import com.bistu.secondhandtradeplatform.mapper.PurchaseHistoryMapper;
import com.bistu.secondhandtradeplatform.service.PurchaseHistoryService;
import com.bistu.secondhandtradeplatform.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {
    @Autowired
    private PurchaseHistoryMapper purchaseHistoryMapper;

    QueryWrapper<PurchaseHistory> queryWrapper = new QueryWrapper<>();

    @Override
    public String addHistory(String userId, String sku) {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setOrderId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        purchaseHistory.setId(userId);
        purchaseHistory.setSku(sku);
        purchaseHistory.setPurchaseTime(new Date());
        purchaseHistory.setStatus(1);
        if (purchaseHistoryMapper.insert(purchaseHistory) != 0) {
            return purchaseHistory.getOrderId();
        } else return "Insert failure.";
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoryByUserId(String userId) {
        QueryWrapper<PurchaseHistory> query = new QueryWrapper<>();
        query.eq("id", userId);
        return purchaseHistoryMapper.selectList(query);
    }

    @Override
    public int deleteUserHistoryByUserId(String userId) {
        queryWrapper.eq("id", userId);
        int i = purchaseHistoryMapper.delete(queryWrapper);
        if (i != 0) {
            return i;
        } else return 0;
    }

    @Override
    public String setPurchaseStatus(String userId, String sku, int status) {
        queryWrapper.eq("id", userId);
        queryWrapper.eq("sku", sku);
        PurchaseHistory purchaseHistory = purchaseHistoryMapper.selectOne(queryWrapper);
        purchaseHistory.setStatus(status);
        if (purchaseHistoryMapper.updateById(purchaseHistory) != 0) {
            return "success.";
        } else {
            return "failure.";
        }
    }

    @Override
    public String insertHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setOrderId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        purchaseHistory.setPurchaseTime(new Date());
        if (purchaseHistoryMapper.insert(purchaseHistory) != 0) {
            return "success.";
        } return "failure.";

    }

    /*
    此接口与其他接口功能冲突，请不要使用
     */
    @Override
    public String setHistoryStatus(String userId, String sku, int status) {
        QueryWrapper<PurchaseHistory> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userId).eq("sku", sku);
        List<PurchaseHistory> purchaseHistory = purchaseHistoryMapper.selectList(wrapper);
        purchaseHistory.forEach(item -> {
            item.setStatus(status);
            purchaseHistoryMapper.updateById(item);
        });
        return "success.";
    }

    @Override
    public List<PurchaseHistory> getOrderList(String shop, int status) {
        QueryWrapper<PurchaseHistory> query = new QueryWrapper<>();
        query.eq("shop", shop).eq("status", status);
        return purchaseHistoryMapper.selectList(query);
    }

    @Override
    public String setOrderStatus(String orderId, int status) {
        PurchaseHistory purchaseHistory =  purchaseHistoryMapper.selectById(orderId);
        purchaseHistory.setStatus(status);
        if (purchaseHistoryMapper.updateById(purchaseHistory) != 0) {
            return "success.";
        } else return "failure.";

    }


}
