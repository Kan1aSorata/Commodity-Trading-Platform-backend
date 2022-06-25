package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.Commodity;
import com.bistu.secondhandtradeplatform.entity.PurchaseHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryService {
    String addHistory(String userId, String sku);
    List<PurchaseHistory> getPurchaseHistoryByUserId(String userId);
    int deleteUserHistoryByUserId(String userId);
    String setPurchaseStatus(String userId, String sku, int status);

    String insertHistory(PurchaseHistory purchaseHistory);
    String setHistoryStatus(String userId, String sku, int status);

    List<PurchaseHistory> getOrderList(String shop, int status);
    String setOrderStatus(String orderId, int status);
}
