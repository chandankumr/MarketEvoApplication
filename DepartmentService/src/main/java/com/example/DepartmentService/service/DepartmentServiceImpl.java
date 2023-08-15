package com.example.DepartmentService.service;

import com.example.DepartmentService.entity.Company;
import com.example.DepartmentService.model.CompanyRequest;
import com.example.DepartmentService.model.CompanyResponse;
import com.example.DepartmentService.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public long saveCompany(CompanyRequest companyRequest) {
        Company company = Company.builder()
                .name(companyRequest.getName())
                .founded(companyRequest.getFounded())
                .company_size(companyRequest.getCompany_size())
                .revenue(companyRequest.getRevenue())
                .industry(companyRequest.getIndustry())
                .address(companyRequest.getAddress())
                .contactEmail(companyRequest.getContactEmail())
                .description(companyRequest.getDescription())
                .build();

        company = departmentRepository.save(company);

        return company.getId();
    }

    @Override
    public CompanyResponse getCompanyById(long id) {
        Company company = departmentRepository.findById(id).get();
        CompanyResponse companyResponse = new CompanyResponse();
        copyProperties(company, companyResponse);
        return companyResponse;
    }

    @Override
    public List<CompanyResponse> getCompanyDetails() {
        List<Company> companyList = departmentRepository.findAll();

        List<CompanyResponse> companyResponses
                = companyList
                .stream()
                .map(company -> {
                    CompanyResponse companyResponse = new CompanyResponse();
                    copyProperties(company, companyResponse);
                    return companyResponse;
                })
                .collect(Collectors.toList());
        return companyResponses;
    }

    @Override
    public String deleteCompanyById(long id) {
        departmentRepository.deleteById(id);
        return "User is deleted successfully {id}";
    }
}
