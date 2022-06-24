package com.bistu.secondhandtradeplatform.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityService {


    List<Commodity> listAll();
    String addCommodity(Commodity commodity);
    String deleteCommodityByName(String name);
    List<Commodity> searchCommodityByName(String name, int sort);
    String getSku(String name);
    String getCommoditySku();
    Commodity getCommodityBySku(String sku);
}
