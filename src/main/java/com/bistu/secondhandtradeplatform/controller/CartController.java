package com.bistu.secondhandtradeplatform.controller;

import com.bistu.secondhandtradeplatform.entity.CartProduct;
import com.bistu.secondhandtradeplatform.entity.Order;
import com.bistu.secondhandtradeplatform.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/addCart")
    public String addCart(String userId, String sku) {
        return cartService.addCart(userId, sku);
    }

    @GetMapping("/addCartByName")
    public String addCartByName(String userId, String name) {
        return cartService.addCartByName(userId, name);
    }

    @GetMapping("/deleteCart")
    public String deleteCart(String userId, String sku) {
        return cartService.deleteCart(userId, sku);
    }

    @GetMapping("/deleteCartByName")
    public String deleteCartByName(String userId, String name) {
        return cartService.deleteCartByName(userId, name);
    }

    @GetMapping("/getCartList")
    public Order getCartList(String userId) {
        return cartService.listCart(userId);
    }
}
