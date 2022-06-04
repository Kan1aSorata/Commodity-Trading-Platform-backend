package com.bistu.secondhandtradeplatform.controller;

import com.bistu.secondhandtradeplatform.entity.Commodity;
import com.bistu.secondhandtradeplatform.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/listAll")
    public List<Commodity> listAll() {
        return commodityService.listAll();
    }

    @PostMapping("/add")
    public String addCommodity(@RequestBody Commodity commodity) {
        return commodityService.addCommodity(commodity);
    }

    @GetMapping("/deleteByName")
    public String deleteCommodityByName(String name) {
        return commodityService.deleteCommodityByName(name);
    }

    @GetMapping("/getSku")
    public String getSku(String name) {
        return commodityService.getSku(name);
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
}
