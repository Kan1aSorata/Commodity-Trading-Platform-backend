package com.bistu.secondhandtradeplatform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bistu.secondhandtradeplatform.entity.*;
import com.bistu.secondhandtradeplatform.mapper.CartMapper;
import com.bistu.secondhandtradeplatform.mapper.CommodityMapper;
import com.bistu.secondhandtradeplatform.service.CartService;
import com.bistu.secondhandtradeplatform.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommodityMapper commodityMapper;
    QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();


    @Override
    public String addCart(String userId, String sku) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setCommoditySku(sku);
        if (cartMapper.insert(cart) != 0) {
            return "add cart success.";
        } else {
            return "failure.";
        }

    }

    @Override
    public String addCartByName(String userId, String name) {
        String sku = commodityService.getSku(name);
        return addCart(userId, sku);
    }

    @Override
    public String deleteCart(String userId, String sku) {
        QueryWrapper<Cart> query = new QueryWrapper<>();
        query.eq("user_id", userId);
        query.eq("commodity_sku", sku);
        System.out.println(userId + "and " + sku);
        if (cartMapper.delete(query) != 0) {
            return "delete success.";
        } else return "failure.";
    }

    @Override
    public String deleteCartByName(String userId, String name) {
        String sku = commodityService.getSku(name);
        System.out.println(sku);
        return deleteCart(userId, sku);
    }

    @Override
    public Order listCart(String userId) {
        QueryWrapper<Cart> query =  new QueryWrapper<>();
        query.eq("user_id", userId);
        List<Cart> cartList = cartMapper.selectList(query);
        ArrayList<CartProduct> arrayList = new ArrayList<>();
        final double[] sum = {0};
        cartList.forEach(item -> {
            Commodity commodity = commodityMapper.selectById(item.getCommoditySku());
            CartProduct cartProduct = new CartProduct();
            cartProduct.setId(commodity.getSku());
            cartProduct.setProductImg(commodity.getPicture());
            cartProduct.setShop(commodity.getShop());
            cartProduct.setName(commodity.getName());
            cartProduct.setPrice("" + commodity.getPrice());
            cartProduct.setCount("1");
            cartProduct.setSales("1000");
            cartProduct.setDescription(commodity.getDescription());
            cartProduct.setTradingStatus("");
            cartProduct.setCost("");
            arrayList.add(cartProduct);
            sum[0] += (Double.parseDouble(cartProduct.getPrice()) * Double.parseDouble(cartProduct.getCount()));
        });
        Order order = new Order();
        order.setCartProducts(arrayList);
        order.setSum(sum[0]);
        return order;
    }
}
