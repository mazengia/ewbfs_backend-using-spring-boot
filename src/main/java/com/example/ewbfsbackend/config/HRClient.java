package com.example.ewbfsbackend.config;

import com.example.ewbfsbackend.dto.EmployeeDto;
import com.example.ewbfsbackend.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "employee-service", url = "${services.hr}")
public interface HRClient {

    @GetMapping("/employees/by-employeeId/{employeeId}")
    EmployeeDto getEmployeeById(@PathVariable("employeeId") String employeeId);

    @GetMapping("/employees/for-payroll")
    List<Employee> getEmployees();

}
