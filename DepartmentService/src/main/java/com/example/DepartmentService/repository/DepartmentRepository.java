package com.example.DepartmentService.repository;

import com.example.DepartmentService.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Company, Long> {
}
