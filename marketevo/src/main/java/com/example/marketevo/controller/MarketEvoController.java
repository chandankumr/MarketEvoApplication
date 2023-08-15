package com.example.marketevo.controller;

import com.example.marketevo.entity.User;
import com.example.marketevo.model.UserRequest;
import com.example.marketevo.model.UserResponse;
import com.example.marketevo.service.MarketEvoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
@Log4j2
public class MarketEvoController {

    @Autowired
    private MarketEvoService marketEvoService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUserDetails() {
//        List<UserResponse> userResponse = (List<UserResponse>) marketEvoService.getUserDetails();
//        log.info("Getting User Details: {}", userResponse);
//        return new ResponseEntity<>(userResponse, HttpStatus.OK);
//        List<UserResponse> userResponses = marketEvoService.getUserDetails();
        List<User> userResponses = marketEvoService.getUserDetails();
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Long> SaveUserDetails(@RequestBody UserRequest userRequest) {
        long userId = marketEvoService.saveUserDetails(userRequest);
        log.info("User Details: {}", userId);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable long id ) {
        UserResponse userResponse = marketEvoService.getUserById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable long id) {
        String deleteResponse = marketEvoService.deleteById(id);
        return deleteResponse;
    }
}
