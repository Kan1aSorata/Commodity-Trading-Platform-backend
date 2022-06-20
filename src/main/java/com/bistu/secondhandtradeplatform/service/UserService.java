package com.bistu.secondhandtradeplatform.service;

import com.bistu.secondhandtradeplatform.entity.User;
import com.bistu.secondhandtradeplatform.entity.UserTransition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    String register(UserTransition userTransition);
    List<UserTransition> list();
    String userVerify(String id, boolean result);
    String login(String username, String password);
    User getUserInfo(String id);
    String changeInfo(User user);
    String deleteUserById(String userId);
}
