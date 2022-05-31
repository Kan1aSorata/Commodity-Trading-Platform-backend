package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    String register(User user);
    String login(String username, String password);
    String changeInfo(User user);
}
