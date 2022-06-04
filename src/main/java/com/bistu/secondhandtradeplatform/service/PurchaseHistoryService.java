package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.PurchaseHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryService {
    String addHistory(String userId, String sku);
    List<PurchaseHistory> getPurchaseHistoryByUserId(String userId);
    int deleteUserHistoryByUserId(String userId);
    String setPurchaseStatus(String userId, String sku, int status);
}
