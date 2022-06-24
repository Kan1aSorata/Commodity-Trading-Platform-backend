package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.ShippingAddress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddressService {
    String addAddress(String userId, String address);

    String deleteAddress(String userId, String address);

    List<ShippingAddress> getAddress(String userId);


}
