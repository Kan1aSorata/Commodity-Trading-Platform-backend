package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.CartProduct;
import com.bistu.secondhandtradeplatform.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CartService {
    String addCart(String userId, String sku);
    String addCartByName(String userId, String name);
    String deleteCart(String userId, String sku);
    String deleteCartByName(String userId, String name);
    Order listCart(String userId);
}
