package com.example.ewbfsbackend.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class Employee implements Serializable {
    private String employeeId;
    private String fullName;
    private String email;
    private BigDecimal salary;
    private String pfAccount;
    private String salaryAccount;
    private EmploymentTypeDTO employmentType;
}

@Data
class EmploymentTypeDTO implements Serializable {
    private String type;
    private boolean calculateIncomeTax;
    private boolean calculatePension;
    private boolean calculateProvidentFund;
    private boolean calculateSocialContribution;
}

