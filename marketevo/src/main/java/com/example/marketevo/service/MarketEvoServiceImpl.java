package com.example.marketevo.service;

import com.example.marketevo.entity.User;
import com.example.marketevo.model.UserRequest;
import com.example.marketevo.model.UserResponse;
import com.example.marketevo.repository.MarketevoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class MarketEvoServiceImpl implements MarketEvoService{

    @Autowired
    private MarketevoRepository marketevoRepository;
    @Override
    public long saveUserDetails(UserRequest userRequest) {

        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .emailId(userRequest.getEmailId())
                .phone(userRequest.getPhone())
                .date(Instant.now())
                .build();

        user = marketevoRepository.save(user);

        return user.getUserId();
    }

    @Override
    public List<User> getUserDetails() {

        List<User> user = marketevoRepository.findAll();
//        UserResponse userResponse = new UserResponse();
//        List<UserResponse> userResponseList = Arrays.asList(userResponse);
//
////        List<UserResponse> userResponse = Arrays.asList(UserResponse);
//        copyProperties(user, userResponseList);

        return user;
    }

    @Override
    public UserResponse getUserById(long id) {
        User user = marketevoRepository.findById(id).get();
        UserResponse userResponse = new UserResponse();
        copyProperties(user, userResponse);
        return userResponse;
    }

    @Override
    public String deleteById(long id) {
        marketevoRepository.deleteById(id);
        return "User is deleted successfully";
    }


}
