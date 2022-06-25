package com.bistu.secondhandtradeplatform.service.impl;

import com.bistu.secondhandtradeplatform.entity.Commodity;
import com.bistu.secondhandtradeplatform.entity.CommodityTransition;
import com.bistu.secondhandtradeplatform.mapper.CommodityMapper;
import com.bistu.secondhandtradeplatform.mapper.CommodityTransitionMapper;
import com.bistu.secondhandtradeplatform.service.CommodityService;
import com.bistu.secondhandtradeplatform.service.CommodityTransitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommodityTransitionServiceImpl implements CommodityTransitionService {

    @Autowired
    private CommodityTransitionMapper commodityTransitionMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private CommodityService commodityService;


    @Override
    public String addCommodity(Commodity commodity) {
        CommodityTransition commodityTransition = new CommodityTransition();
        commodityTransition.setName(commodity.getName());
        commodityTransition.setPrice(commodity.getPrice());
        commodityTransition.setCategory(commodity.getCategory());
        commodityTransition.setPicture(commodity.getPicture());
        commodityTransition.setDescription(commodity.getDescription());
        commodityTransition.setStock(commodity.getStock());
        commodityTransition.setShop(commodity.getShop());
        if (commodityTransitionMapper.insert(commodityTransition) != 0) {
            return "success.";
        } return "failure";
    }

    @Override
    public List<CommodityTransition> list() {
        return commodityTransitionMapper.selectList(null);
    }

    @Override
    public String commodityVerify(String id, boolean result) {
        if (result) {
            CommodityTransition commodityTransition = commodityTransitionMapper.selectById(id);
            Commodity commodity = new Commodity();
            commodity.setSku(commodityService.getCommoditySku());
            commodity.setName(commodityTransition.getName());
            commodity.setPrice(commodityTransition.getPrice());
            commodity.setCategory(commodityTransition.getCategory());
            commodity.setPicture(commodityTransition.getPicture());
            commodity.setDescription(commodityTransition.getDescription());
            commodity.setStock(commodityTransition.getStock());
            commodity.setStatus(1);
            commodity.setShop(commodityTransition.getShop());
            commodityMapper.insert(commodity);
            commodityTransitionMapper.deleteById(id);
            return "Accept success.";
        } else {
            commodityTransitionMapper.deleteById(id);
            return "Reject success.";
        }
    }
}
