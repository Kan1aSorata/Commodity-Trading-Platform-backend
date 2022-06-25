package com.bistu.secondhandtradeplatform.controller;

import com.bistu.secondhandtradeplatform.entity.Commodity;
import com.bistu.secondhandtradeplatform.entity.PurchaseHistory;
import com.bistu.secondhandtradeplatform.mapper.CommodityTransitionMapper;
import com.bistu.secondhandtradeplatform.service.CommodityService;
import com.bistu.secondhandtradeplatform.service.CommodityTransitionService;
import com.bistu.secondhandtradeplatform.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityTransitionService commodityTransitionService;

    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @GetMapping("/listAll")
    public List<Commodity> listAll() {
        return commodityService.listAll();
    }

    @PostMapping("/add")
    public String addCommodity(@RequestBody Commodity commodity) {
        return commodityTransitionService.addCommodity(commodity);
    }

    @GetMapping("/deleteByName")
    public String deleteCommodityByName(String name) {
        return commodityService.deleteCommodityByName(name);
    }

    @GetMapping("/getSku")
    public String getSku(String name) {
        return commodityService.getSku(name);
    }

    @GetMapping("/getCommoditySku")
    public String getCommoditySku() {
        return commodityService.getCommoditySku();
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
    @GetMapping("/searchByName")
    public List<Commodity> searchCommodityByName(String name, int sort) {
        return commodityService.searchCommodityByName(name, sort);
    }

    @GetMapping("/getCommodityBySku")
    public Commodity getCommodityBySku(String sku) {
        return commodityService.getCommodityBySku(sku);
    }

    @GetMapping("/getOrderList")
    public List<PurchaseHistory> getOrderList(String shop, int status) {
        return purchaseHistoryService.getOrderList(shop, status);
    }

    @GetMapping("/setOrderList")
    public String setOrderStatus(String orderId, int status) {
        return purchaseHistoryService.setOrderStatus(orderId, status);
    }

    @GetMapping("/setCommodityParams")
    public String setCommodityParams(String sku) {
        return null;
    }

    @GetMapping("/searchCommodityByCategory")
    public List<Commodity> searchCommodityByCategory(String category, int sort) {
        return commodityService.searchCommodityByCategory(category, sort);
    }

}
