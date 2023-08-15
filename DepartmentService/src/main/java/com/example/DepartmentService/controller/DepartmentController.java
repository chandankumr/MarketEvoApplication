package com.example.DepartmentService.controller;

import com.example.DepartmentService.model.CompanyRequest;
import com.example.DepartmentService.model.CompanyResponse;
import com.example.DepartmentService.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Long> saveCompany(@RequestBody CompanyRequest companyRequest) {
        long id = departmentService.saveCompany(companyRequest);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable long id) {
        CompanyResponse companyResponse = departmentService.getCompanyById(id);
        return new ResponseEntity<>(companyResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getCompanyDetails() {
        List<CompanyResponse> companyResponseList = departmentService.getCompanyDetails();
        return new ResponseEntity<>(companyResponseList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteCompanyById(@PathVariable long id) {
        String deleteResponse = departmentService.deleteCompanyById(id);
        return deleteResponse;
    }
}
