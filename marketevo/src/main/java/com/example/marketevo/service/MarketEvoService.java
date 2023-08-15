package com.example.marketevo.service;

import com.example.marketevo.entity.User;
import com.example.marketevo.model.UserRequest;
import com.example.marketevo.model.UserResponse;

import java.util.List;

public interface MarketEvoService {
    long saveUserDetails(UserRequest userRequest);

    List<User> getUserDetails();

    UserResponse getUserById(long id);


    String deleteById(long id);
}
