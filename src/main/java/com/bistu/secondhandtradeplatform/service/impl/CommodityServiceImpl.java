package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.Commodity;
import com.bistu.secondhandtradeplatform.mapper.CommodityMapper;
import com.bistu.secondhandtradeplatform.service.CommodityService;
import com.bistu.secondhandtradeplatform.util.CommodityComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();

    @Override
    public List<Commodity> listAll() {
        return commodityMapper.selectList(null);
    }

    @Override
    public String addCommodity(Commodity commodity) {
        if (commodityMapper.insert(commodity) != 0) {
            return commodity.getSku();
        } else return "failure.";
    }

    public String getCommoditySku() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    @Override
    public String deleteCommodityByName(String name) {
        queryWrapper.eq("name", name);
        if (commodityMapper.delete(queryWrapper) != 0) {
            return "success.";
        } else return "failure";
    }

    /*
    sort:
      0:default
      1:price(high - low)
      2:price(low - high)
      3:score(high - low)
      4:score(low - high)
      5:sales(high - low)
      6:sales(low - high)
   */
    @Override
    public List<Commodity> searchCommodityByName(String name, int sort) {
        List<Commodity> commodityList = commodityMapper.selectList(null);
        if (!Objects.equals(name, "")) {
            queryWrapper.eq("name", name);
            commodityList = commodityMapper.selectList(queryWrapper);
        }
        CommodityComparator commodityComparator = new CommodityComparator();
        switch (sort) {
            case 1: commodityList.sort(commodityComparator::compareByPriceHL);break;
            case 2: commodityList.sort(commodityComparator::compareByPriceLH);break;
            case 3: commodityList.sort(commodityComparator::compareByScoreHL);break;
            case 4: commodityList.sort(commodityComparator::compareByScoreLH);break;
            case 5: commodityList.sort(commodityComparator::compareBySalesHL);break;
            case 6: commodityList.sort(commodityComparator::compareBySalesLH);break;
            default:break;
        }
        return commodityList;
    }

    @Override
    public String getSku(String name) {
        queryWrapper.eq("name", name);
        return commodityMapper.selectOne(queryWrapper).getSku();
    }
}
