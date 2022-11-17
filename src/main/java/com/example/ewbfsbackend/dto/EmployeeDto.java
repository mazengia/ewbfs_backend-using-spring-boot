package com.example.ewbfsbackend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeDto {
    private String employeeId;
    private String fullName;
    private String email;
    private BigDecimal salary;
    private String pfAccount;
    private String salaryAccount;

}
