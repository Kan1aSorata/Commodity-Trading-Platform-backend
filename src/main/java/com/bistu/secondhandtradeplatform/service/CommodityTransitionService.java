package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.Commodity;
import com.bistu.secondhandtradeplatform.entity.CommodityTransition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityTransitionService {
    String addCommodity(Commodity commodity);
    List<CommodityTransition> list();
    String commodityVerify(String id, boolean result);
}
