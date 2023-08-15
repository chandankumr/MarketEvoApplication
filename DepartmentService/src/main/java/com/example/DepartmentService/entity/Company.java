package com.example.DepartmentService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "COMPANY_DETAILS")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FOUNDED")
    private Long founded;

    @Column(name = "COMPANY_SIZE")
    private String company_size;

    @Column(name = "REVENUE")
    private String revenue;

    @Column(name = "INDUSTRY")
    private String industry;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL_ID")
    private String contactEmail;

    @Column(name = "DESCRIPTION")
    private String description;

}
