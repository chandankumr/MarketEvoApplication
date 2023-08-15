package com.example.marketevo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phone;
}
