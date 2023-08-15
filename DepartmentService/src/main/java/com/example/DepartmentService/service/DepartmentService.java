package com.example.DepartmentService.service;

import com.example.DepartmentService.model.CompanyRequest;
import com.example.DepartmentService.model.CompanyResponse;

import java.util.List;

public interface DepartmentService {
    long saveCompany(CompanyRequest companyRequest);

    CompanyResponse getCompanyById(long id);

    List<CompanyResponse> getCompanyDetails();

    String deleteCompanyById(long id);
}
