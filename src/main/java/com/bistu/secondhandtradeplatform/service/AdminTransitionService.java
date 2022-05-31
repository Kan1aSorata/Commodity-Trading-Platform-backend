package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.AdminTransition;
import com.bistu.secondhandtradeplatform.entity.User;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminTransitionService {
    String register(AdminTransition adminTransition);
    List<AdminTransition> list();
    String adminVerify(String adminId, boolean result);
}
