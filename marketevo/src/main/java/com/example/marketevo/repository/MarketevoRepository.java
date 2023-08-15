package com.example.marketevo.repository;

import com.example.marketevo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketevoRepository extends JpaRepository<User, Long> {
}
